package com.ioexception.android.ldrp_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class VideoOptions1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_options)

        //value will be 20 to reach here
        var choiceNumber = intent.getIntExtra("choiceNumber", 20)

        val homeButton = findViewById<ImageButton>(R.id.video1_home)
        homeButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            choiceNumber = 0
            homeIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(homeIntent)
        }

        val televisionButton = findViewById<Button>(R.id.VideoTelevision)
        televisionButton.setOnClickListener {
            choiceNumber+=1
            choiceNumber*=10
            val televisionIntent = Intent(this, VideoOptions2::class.java)
            televisionIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(televisionIntent)
        }

        val youtubeButton = findViewById<Button>(R.id.VideoYoutube)
        youtubeButton.setOnClickListener {
            val youtubeIntent = Intent(this, TelevisionOptions::class.java)
            choiceNumber+=2
            choiceNumber*=100
            youtubeIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(youtubeIntent)
        }

        val instagramButton = findViewById<Button>(R.id.VideoInstagram)
        instagramButton.setOnClickListener {
            val instagramIntent = Intent(this, TelevisionOptions::class.java)
            choiceNumber+=3
            choiceNumber*=100
            instagramIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(instagramIntent)
        }

        supportActionBar?.hide()
    }

    override fun onBackPressed() {

    }
}