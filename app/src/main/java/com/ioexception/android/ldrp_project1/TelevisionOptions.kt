package com.ioexception.android.ldrp_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton

class TelevisionOptions : AppCompatActivity() {

    var videoGenreChoices: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       setContentView(R.layout.television_options)

        var choiceNumber = intent.getIntExtra("choiceNumber", 2000)

        val homeButton = findViewById<ImageButton>(R.id.television_home)
        homeButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            choiceNumber = 0
            homeIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(homeIntent)
        }

        findViewById<Button>(R.id.videoGenreProceed).setOnClickListener {
            val cartIntent = Intent(this, Cart::class.java)
            cartIntent.putExtra("choiceNumber", choiceNumber)
            cartIntent.putStringArrayListExtra("extras", videoGenreChoices)
            startActivity(cartIntent)
        }

        supportActionBar?.hide()
    }

    override fun onBackPressed() {

    }

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.EntertainmentCB -> {
                    if (checked) {
                        videoGenreChoices.add("Entertainment")
                    } else {
                        videoGenreChoices.remove("Entertainment")
                    }
                }
                R.id.MoviesCB -> {
                    if (checked) {
                        videoGenreChoices.add("Movies")
                    } else {
                        videoGenreChoices.remove("Movies")
                    }
                }
                R.id.MusicCB -> {
                    if (checked) {
                        videoGenreChoices.add("Music")
                    } else {
                        videoGenreChoices.remove("Music")
                    }
                }
                R.id.KidsCB -> {
                    if (checked) {
                        videoGenreChoices.add("Kids")
                    } else {
                        videoGenreChoices.remove("Kids")
                    }
                }
                R.id.InformationCB -> {
                    if (checked) {
                        videoGenreChoices.add("Information")
                    } else {
                        videoGenreChoices.remove("Information")
                    }
                }
                R.id.NewsCB -> {
                    if (checked) {
                        videoGenreChoices.add("News")
                    } else {
                        videoGenreChoices.remove("News")
                    }
                }
                R.id.BusinessCB -> {
                    if (checked) {
                        videoGenreChoices.add("Business")
                    } else {
                        videoGenreChoices.remove("Business")
                    }
                }
            }
        }
    }
}