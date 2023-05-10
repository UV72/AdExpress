package com.ioexception.android.ldrp_project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton

class NewspaperOptions : AppCompatActivity() {

    var newspaperChoices: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newspaper_options)
        supportActionBar?.hide()

        var choiceNumber = intent.getIntExtra("choiceNumber", 2000)

        val homeButton = findViewById<ImageButton>(R.id.newspaper_home)
        homeButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            choiceNumber = 0
            homeIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(homeIntent)
        }

        findViewById<Button>(R.id.newspaperProceed).setOnClickListener {
            val cartIntent = Intent(this, Cart::class.java)
            cartIntent.putExtra("choiceNumber", choiceNumber)
            cartIntent.putStringArrayListExtra("extras", newspaperChoices)
            startActivity(cartIntent)
        }

    }

    override fun onBackPressed() {
        
    }

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.GujaratSamachar -> {
                    if (checked) {
                        newspaperChoices.add("GujaratSamachar")
                    } else {
                        newspaperChoices.remove("GujaratSamachar")
                    }
                }
                R.id.DivyaBhaskar -> {
                    if (checked) {
                        newspaperChoices.add("DivyaBhaskar")
                    } else {
                        newspaperChoices.remove("DivyaBhaskar")
                    }
                }
                R.id.Sandesh -> {
                    if (checked) {
                        newspaperChoices.add("Sandesh")
                    } else {
                        newspaperChoices.remove("Sandesh")
                    }
                }
                R.id.NirmalGujarat -> {
                    if (checked) {
                        newspaperChoices.add("NirmalGujarat")
                    } else {
                        newspaperChoices.remove("NirmalGujarat")
                    }
                }
                R.id.TheHindu -> {
                    if (checked) {
                        newspaperChoices.add("TheHindu")
                    } else {
                        newspaperChoices.remove("TheHindu")
                    }
                }
                R.id.TheTimesOfIndia -> {
                    if (checked) {
                        newspaperChoices.add("TheTimesOfIndia")
                    } else {
                        newspaperChoices.remove("TheTimesOfIndia")
                    }
                }
                R.id.HindustanTimes -> {
                    if (checked) {
                        newspaperChoices.add("HindustanTimes")
                    } else {
                        newspaperChoices.remove("HindustanTimes")
                    }
                }
            }
        }
    }
}