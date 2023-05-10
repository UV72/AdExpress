package com.ioexception.android.ldrp_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class PrintOptions4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.print_options_4)

        var choiceNumber = intent.getIntExtra("choiceNumber", 30000)

        val englishButton = findViewById<Button>(R.id.english_button)
        val hindiButton = findViewById<Button>(R.id.hindi_button)
        val gujaratiButton = findViewById<Button>(R.id.gujarati_button)

        val homeButton = findViewById<ImageButton>(R.id.print4_home)
        homeButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            choiceNumber = 0
            homeIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(homeIntent)
        }

        englishButton.setOnClickListener {
            val newspaperOptionsIntent = Intent(this, NewspaperOptions::class.java)
            choiceNumber+=1
            choiceNumber*=10
            newspaperOptionsIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(newspaperOptionsIntent)
        }
        hindiButton.setOnClickListener {
            val newspaperOptionsIntent = Intent(this, NewspaperOptions::class.java)
            choiceNumber+=2
            choiceNumber*=10
            newspaperOptionsIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(newspaperOptionsIntent)
        }
        gujaratiButton.setOnClickListener {
            val newspaperOptionsIntent = Intent(this, NewspaperOptions::class.java)
            choiceNumber+=3
            choiceNumber*=10
            newspaperOptionsIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(newspaperOptionsIntent)
        }

        supportActionBar?.hide()
    }

    override fun onBackPressed() {

    }
}