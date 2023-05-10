package com.ioexception.android.ldrp_project1

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.util.*

data class Customer(
    var id: String?,
    var emailDB: String? = null,
    var choiceDB: Int,
    var fileName: String? = null,
    var extras: Array<String>?
)

class UploadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)
        supportActionBar?.hide()

        val user = Firebase.auth.currentUser
        val email = user?.email

        //This function requests permission for the access to user's files
        val requestPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            it?.let {
                if(it){
                    Toast.makeText(this, "File access granted", Toast.LENGTH_SHORT).show()
                }
            }
        }

        //This function accesses files and reads them in the form of a byte array
        val fileAccess = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            it.data?.data?.let {
                val inputStream = this.contentResolver.openInputStream(it)
                inputStream?.readBytes()?.let {
                    if (email != null) {
                        uploadFile(it, email)
                    }else{
                        uploadFile(it, "UnknownUser")
                    }
                }
                inputStream?.close()
            }
        }


        //This function checks if the version is greater than oreo, if it is then it requests for file permissions
        fun sdkIntOverO(context: Context, call: ()->Unit){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                if(ActivityCompat.checkSelfPermission(context, android.Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED){
                    call.invoke()
                }else{
                    requestPermission.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                }
            }
        }

        val choiceNumber = intent.getIntExtra("choiceNumber", 10000)
        val reverseChoice = reverseNumber(choiceNumber)
        val signOutButton = findViewById<Button>(R.id.signOut)
        val uploadButton = findViewById<Button>(R.id.UploadButton)

        uploadButton.setOnClickListener{

            if (reverseChoice%10 == 1){

                //audio ads were selected
                Toast.makeText(this, "Please select an audio file", Toast.LENGTH_SHORT).show()
                sdkIntOverO(this){
                    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                    intent.addCategory(Intent.CATEGORY_OPENABLE)
                    intent.type = "*/*"
                    fileAccess.launch(intent)
                }

            }else if (reverseChoice%10 == 2){

                //video ads were selected
                Toast.makeText(this, "Please select a video file", Toast.LENGTH_SHORT).show()
                sdkIntOverO(this){
                    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                    intent.addCategory(Intent.CATEGORY_OPENABLE)
                    intent.type = "*/*"
                    fileAccess.launch(intent)
                }
            }else{

                //print ads were selected
                Toast.makeText(this, "Please select an image file", Toast.LENGTH_SHORT).show()
                sdkIntOverO(this){
                    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                    intent.addCategory(Intent.CATEGORY_OPENABLE)
                    intent.type = "*/*"
                    fileAccess.launch(intent)
                }

            }

        }

        signOutButton.setOnClickListener{
            Firebase.auth.signOut()
            val returnToAuthIntent = Intent(this, AuthenticationActivity::class.java)
            returnToAuthIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(returnToAuthIntent)
        }
    }

    private fun uploadFile(it: ByteArray, email: String) {
        val storageReference = FirebaseStorage.getInstance().reference
        val extras = intent.getStringArrayExtra("extras")

        storageReference.child("audioAds/${email+Date().time}").putBytes(it)
            .addOnSuccessListener {
                Toast.makeText(this, "Upload success", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{
                Toast.makeText(this, "Upload failed", Toast.LENGTH_SHORT).show()
            }
            .addOnCompleteListener{
                Toast.makeText(this, "Upload Complete", Toast.LENGTH_SHORT).show()
            }
    }

    private fun reverseNumber(choiceNumber: Int): Int {
        var num = choiceNumber
        var reverse = 0
        var rem: Int
        while(num>0){
            rem = num%10
            reverse = (reverse*10) + rem
            num /= 10
        }
        return reverse
    }
}