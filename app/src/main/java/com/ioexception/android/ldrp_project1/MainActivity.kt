package com.ioexception.android.ldrp_project1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var choiceNumber = 0
        val audioAd = findViewById<Button>(R.id.audioAds)
        audioAd.setOnClickListener{
            choiceNumber+=1
            choiceNumber*=10
            val audioOptionsIntent = Intent(this, AudioOptions1::class.java)
            audioOptionsIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(audioOptionsIntent)
        }

        val videoAd = findViewById<Button>(R.id.videoAds)
        videoAd.setOnClickListener{
            choiceNumber+=2
            choiceNumber*=10
            val videoOptionsIntent = Intent(this, VideoOptions1::class.java)
            videoOptionsIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(videoOptionsIntent)
        }

        val printAd = findViewById<Button>(R.id.printAds)
        printAd.setOnClickListener{
            choiceNumber+=3
            choiceNumber*=10
            val printOptionsIntent = Intent(this, PrintOptions1::class.java)
            printOptionsIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(printOptionsIntent)
        }

        supportActionBar?.hide()

    }
}