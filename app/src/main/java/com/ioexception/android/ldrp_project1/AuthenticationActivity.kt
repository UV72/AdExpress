package com.ioexception.android.ldrp_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthenticationActivity : AppCompatActivity() {



    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        supportActionBar?.hide()
        auth = FirebaseAuth.getInstance()
        val registerButton = findViewById<Button>(R.id.Auth_register)
        val loginButton = findViewById<Button>(R.id.Auth_login)

        registerButton.setOnClickListener{
            createUser()
        }

        loginButton.setOnClickListener{
            loginUser()
        }

    }

    private fun loginUser() {

        val emailBox = findViewById<EditText>(R.id.emailEditText)
        val passwordBox = findViewById<EditText>(R.id.passwordEditText)
        var email = emailBox.text.toString()
        var password = passwordBox.text.toString()

        if(TextUtils.isEmpty(email)){

            Toast.makeText(this, "Email cannot be empty!", Toast.LENGTH_LONG).show()

        }else if(TextUtils.isEmpty(password)){

            Toast.makeText(this, "Password cannot be empty!", Toast.LENGTH_LONG).show()

        }else{

            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this, "User logged in successfully", Toast.LENGTH_SHORT).show()
                    var uploadIntent = Intent(this, UploadActivity::class.java)
                    val choiceNumber = intent.getIntExtra("choiceNumber", 10000)
                    uploadIntent.putExtra("choiceNumber", choiceNumber)
                    startActivity(uploadIntent)
                }else{
                    Toast.makeText(this, "User login failed: " + it.exception?.message, Toast.LENGTH_LONG).show()
                }
            }

        }
    }

    private fun createUser() {

        val emailBox = findViewById<EditText>(R.id.emailEditText)
        val passwordBox = findViewById<EditText>(R.id.passwordEditText)
        var email = emailBox.text.toString()
        var password = passwordBox.text.toString()

        if(TextUtils.isEmpty(email)){

            Toast.makeText(this, "Email cannot be empty!", Toast.LENGTH_LONG).show()

        }else if(TextUtils.isEmpty(password)){

            Toast.makeText(this, "Password cannot be empty!", Toast.LENGTH_LONG).show()

        }else{

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this, "User created successfully", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "User creation failed: " + it.exception?.message, Toast.LENGTH_LONG).show()
                }
            }

        }
    }

    override fun onStart() {
        super.onStart()
        var user = auth.currentUser
        if(user!=null){
            var uploadIntent = Intent(this, UploadActivity::class.java)
            val choiceNumber = intent.getIntExtra("choiceNumber", 10000)
            uploadIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(uploadIntent)
        }

    }
}