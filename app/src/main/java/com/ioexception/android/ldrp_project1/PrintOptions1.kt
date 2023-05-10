package com.ioexception.android.ldrp_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class PrintOptions1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.print_options)

        var choiceNumber = intent.getIntExtra("choiceNumber", 30)

        val newspaperButton = findViewById<Button>(R.id.PrintNewspaper)
        val pamphletButton = findViewById<Button>(R.id.PrintPamphlet)
        val bannerButton = findViewById<Button>(R.id.PrintBanner)

        val homeButton = findViewById<ImageButton>(R.id.print1_home)
        homeButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            choiceNumber = 0
            homeIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(homeIntent)
        }

        newspaperButton.setOnClickListener {
            val sizeIntent = Intent(this, PrintOptions2::class.java)
            choiceNumber+=1
            choiceNumber*=10
            sizeIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(sizeIntent)
        }

        pamphletButton.setOnClickListener {
            val colorIntent = Intent(this, PrintOptions3::class.java)
            choiceNumber+=2
            choiceNumber*=100
            colorIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(colorIntent)
        }

        bannerButton.setOnClickListener {
            val sizeIntent = Intent(this, PrintOptions2::class.java)
            choiceNumber+=3
            choiceNumber*=10
            sizeIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(sizeIntent)
        }

        supportActionBar?.hide()
    }

    override fun onBackPressed() {
    }
}