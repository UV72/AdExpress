package com.ioexception.android.ldrp_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class PrintOptions2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.print_options_2)

        var choiceNumber = intent.getIntExtra("choiceNumber", 300)

        val fullPageButton = findViewById<Button>(R.id.full_page)
        val halfPageButton = findViewById<Button>(R.id.half_page)
        val quarterPageButton = findViewById<Button>(R.id.quarter_page)

        val homeButton = findViewById<ImageButton>(R.id.print2_home)
        homeButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            choiceNumber = 0
            homeIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(homeIntent)
        }

        fullPageButton.setOnClickListener {
            val colorIntent = Intent(this, PrintOptions3::class.java)
            choiceNumber+=1
            choiceNumber*=10
            colorIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(colorIntent)
        }
        halfPageButton.setOnClickListener {
            val colorIntent = Intent(this, PrintOptions3::class.java)
            choiceNumber+=2
            choiceNumber*=10
            colorIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(colorIntent)
        }
        quarterPageButton.setOnClickListener {
            val colorIntent = Intent(this, PrintOptions3::class.java)
            choiceNumber+=3
            choiceNumber*=10
            colorIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(colorIntent)
        }
        supportActionBar?.hide()
    }

    override fun onBackPressed() {

    }
}