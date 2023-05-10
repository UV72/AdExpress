package com.ioexception.android.ldrp_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton

class AudioOptions: AppCompatActivity() {

    var choices: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.audio_options_linear)
        supportActionBar?.hide()

        val proceedButton = findViewById<ImageButton>(R.id.audio_proceed)
        proceedButton.setOnClickListener{
            val cartIntent = Intent(this, Cart::class.java)
            cartIntent.putExtra("choicesList", choices)
            startActivity(cartIntent)
        }
    }

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.radioCheckBox -> {
                    if (checked) {
                        choices.add("television")
                    } else {
                        choices.remove("television")
                    }
                }
                R.id.spotifyCheckBox -> {
                    if (checked) {
                        choices.add("youtube")
                    } else {
                        choices.remove("youtube")
                    }
                }
                R.id.podcastCheckBox -> {
                    if (checked) {
                        choices.add("outdoor")
                    } else {
                        choices.remove("outdoor")
                    }
                }
            }
        }
    }
}