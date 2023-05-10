package com.ioexception.android.ldrp_project1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class AudioOptions1: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.audio_options)


        //choice number will be 10
        var choiceNumber = intent.getIntExtra("choiceNumber", 10)

        val homeButton = findViewById<ImageButton>(R.id.audio1_home)
        homeButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            choiceNumber = 0
            homeIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(homeIntent)
        }

        val radioOption = findViewById<Button>(R.id.AudioRadioOptions)
        radioOption.setOnClickListener {
            choiceNumber+=1
            choiceNumber*=10
            val radioOptions = Intent(this,AudioOptions2::class.java)
            radioOptions.putExtra("choiceNumber", choiceNumber)
            startActivity(radioOptions)
        }

        val spotifyOption = findViewById<Button>(R.id.AudioSpotify)
        spotifyOption.setOnClickListener {
            choiceNumber+=2
            choiceNumber*=10
            val radioOptions = Intent(this,AudioOptions2::class.java)
            radioOptions.putExtra("choiceNumber", choiceNumber)
            startActivity(radioOptions)
        }

        val podcastOption = findViewById<Button>(R.id.AudioPodcast)
        podcastOption.setOnClickListener {
            choiceNumber+=3
            choiceNumber*=10
            val radioOptions = Intent(this,AudioOptions2::class.java)
            radioOptions.putExtra("choiceNumber", choiceNumber)
            startActivity(radioOptions)
        }

        supportActionBar?.hide()

    }

    override fun onBackPressed() {

    }
}