package com.ioexception.android.ldrp_project1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class PrintOptions3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.print_options_3)

        var choiceNumber = intent.getIntExtra("choiceNumber", 3000)

        val monochromeButton = findViewById<Button>(R.id.monochrome_button)
        val coloredButton = findViewById<Button>(R.id.colored_button)

        val homeButton = findViewById<ImageButton>(R.id.print3_home)
        homeButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            choiceNumber = 0
            homeIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(homeIntent)
        }

        monochromeButton.setOnClickListener {
            val languageIntent = Intent(this, PrintOptions4::class.java)
            choiceNumber+=1
            choiceNumber*=10
            languageIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(languageIntent)
        }
        coloredButton.setOnClickListener {
            val languageIntent = Intent(this, PrintOptions4::class.java)
            choiceNumber+=2
            choiceNumber*=10
            languageIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(languageIntent)
        }
        supportActionBar?.hide()
    }

    override fun onBackPressed() {

    }
}