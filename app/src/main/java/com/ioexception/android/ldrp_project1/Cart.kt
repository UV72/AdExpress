package com.ioexception.android.ldrp_project1

import android.app.ActionBar.LayoutParams
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Cart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart)
        supportActionBar?.hide()

        val parentLayout = findViewById<LinearLayout>(R.id.LinearCart1)
        val choiceNumber = intent.getIntExtra("choiceNumber", 10000)
        val orderString = OrderCodes.codes[choiceNumber]
        val extras = intent.getStringArrayExtra("extras")

//        var extrasString: String? = null
//        if (extras != null) {
//
//            for (item in extras){
//                extrasString = "$extrasString\n$item"
//            }
//
//        }
//        val pricesMap: HashMap<String, Int> = HashMap(9)
//        pricesMap["television"] = 23000
//        pricesMap["youtube"] = 10000
//        pricesMap["outdoor"] = 18000
//
//        var totalPrice = 0
//        val choices = intent.extras
//        val finalList = choices?.getStringArrayList("choicesList")
//
//        finalList?.forEach { item ->
//            val textView = TextView(this)
//
//            totalPrice+= pricesMap[item]!!
//
//            textView.text = item
//            textView.textSize= 25F
//            textView.setTextColor( Color.parseColor("#000000") )
//            textView.setPadding(0,0,25,25)
//            parentLayout.addView(textView)
//        }

        val textView = TextView(this)
        textView.text = orderString
        textView.textSize= 20F
        textView.setTextColor( Color.parseColor("#FFFFFF") )
        textView.setPadding(0,75,25,25)
        parentLayout.addView(textView)

        extras?.forEach {
            val extrasTextView = TextView(this)
            extrasTextView.text = it.toString()
            extrasTextView.textSize= 20F
            extrasTextView.setTextColor( Color.parseColor("#FFFFFF") )
            extrasTextView.setPadding(0,25,25,25)
            parentLayout.addView(extrasTextView)
        }


//        val space = Space(this)
//        var spaceParams = space.layoutParams
//        spaceParams.height=0

//        val proceed = ImageButton(this)
//        proceed.setBackgroundResource(R.drawable.proceed_button)
//        val proceedLayout = LayoutParams(228*2,49*2)
//        proceed.layoutParams=proceedLayout
//        parentLayout.addView(proceed)
//        proceed.setOnClickListener {
//            val authIntent = Intent(this, AuthenticationActivity::class.java)
//            authIntent.putExtra("choiceNumber", choiceNumber)
//            startActivity(authIntent)
//        }

        val proceed = findViewById<Button>(R.id.cartProceed)
        proceed.setOnClickListener {
            val authIntent = Intent(this, AuthenticationActivity::class.java)
            authIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(authIntent)
        }

    }
}