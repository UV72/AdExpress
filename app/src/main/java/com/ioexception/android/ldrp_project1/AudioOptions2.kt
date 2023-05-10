package com.ioexception.android.ldrp_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class AudioOptions2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.audio_options_2)

        //choice number will be 1XX
        var choiceNumber = intent.getIntExtra("choiceNumber", 100)

        val homeButton = findViewById<ImageButton>(R.id.audio2_home)
        homeButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            choiceNumber = 0
            homeIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(homeIntent)
        }

        val liveReadButton = findViewById<Button>(R.id.LiveRead)
        liveReadButton.setOnClickListener {
            choiceNumber+=1
            choiceNumber*=10
            if ((choiceNumber/100)%10==1){
                val radioOptions = Intent(this,RadioOptions::class.java)
                radioOptions.putExtra("choiceNumber", choiceNumber)
                startActivity(radioOptions)
            }
            else{
                val cartIntent = Intent(this, Cart::class.java)
                cartIntent.putExtra("choiceNumber", choiceNumber)
                startActivity(cartIntent)
            }

        }


        val ProducedButton = findViewById<Button>(R.id.Produced)
        ProducedButton.setOnClickListener {
            choiceNumber+=2
            choiceNumber*=10
            if ((choiceNumber/100)%10==1){
                val radioOptions = Intent(this,RadioOptions::class.java)
                radioOptions.putExtra("choiceNumber", choiceNumber)
                startActivity(radioOptions)
            }
            else{
                val cartIntent = Intent(this, Cart::class.java)
                cartIntent.putExtra("choiceNumber", choiceNumber)
                startActivity(cartIntent)
            }
        }

        supportActionBar?.hide()
    }

    override fun onBackPressed() {

    }
}