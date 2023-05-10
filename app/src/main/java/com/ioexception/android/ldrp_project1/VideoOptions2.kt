package com.ioexception.android.ldrp_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class VideoOptions2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_options_2)

        var choiceNumber = intent.getIntExtra("choiceNumber", 200)

        val homeButton = findViewById<ImageButton>(R.id.video2_home)
        homeButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            choiceNumber = 0
            homeIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(homeIntent)
        }

        val astonBand = findViewById<Button>(R.id.AstonBandButton)
        astonBand.setOnClickListener {
            val genreIntent = Intent(this, TelevisionOptions::class.java)
            choiceNumber+=1
            choiceNumber*=100
            genreIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(genreIntent)
        }

        val scroller = findViewById<Button>(R.id.ScrollerButton)
        scroller.setOnClickListener {
            val genreIntent = Intent(this, TelevisionOptions::class.java)
            choiceNumber+=2
            choiceNumber*=100
            genreIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(genreIntent)
        }

        val regularFCT = findViewById<Button>(R.id.FCTButton)
        regularFCT.setOnClickListener {
            val genreIntent = Intent(this, TelevisionOptions::class.java)
            choiceNumber+=3
            choiceNumber*=100
            genreIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(genreIntent)
        }

        val lBand = findViewById<Button>(R.id.LBandButton)
        lBand.setOnClickListener {
            val genreIntent = Intent(this, TelevisionOptions::class.java)
            choiceNumber+=4
            choiceNumber*=100
            genreIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(genreIntent)
        }

        val banner = findViewById<Button>(R.id.BannerButton)
        banner.setOnClickListener {
            val genreIntent = Intent(this, TelevisionOptions::class.java)
            choiceNumber+=5
            choiceNumber*=100
            genreIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(genreIntent)
        }

        val teleshopping = findViewById<Button>(R.id.TeleshoppingButton)
        teleshopping.setOnClickListener {
            val genreIntent = Intent(this, TelevisionOptions::class.java)
            choiceNumber+=6
            choiceNumber*=100
            genreIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(genreIntent)
        }

        supportActionBar?.hide()
    }

    override fun onBackPressed() {

    }
}