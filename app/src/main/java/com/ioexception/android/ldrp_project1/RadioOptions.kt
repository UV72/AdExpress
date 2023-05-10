package com.ioexception.android.ldrp_project1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RadioOptions : AppCompatActivity() {

    private var radioChoices: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.radio_options)

        var choiceNumber = intent.getIntExtra("choiceNumber", 1000)
        findViewById<Button>(R.id.RadioProceed).setOnClickListener {
            val cartIntent = Intent(this, Cart::class.java)
            cartIntent.putExtra("choiceNumber", choiceNumber)
            Toast.makeText(this, "The extras has ${radioChoices.size} elements", Toast.LENGTH_LONG).show()
            cartIntent.putStringArrayListExtra("extras", radioChoices)
            startActivity(cartIntent)
        }

        val homeButton = findViewById<ImageButton>(R.id.radio_home)
        homeButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            choiceNumber = 0
            homeIntent.putExtra("choiceNumber", choiceNumber)
            startActivity(homeIntent)
        }

        supportActionBar?.hide()
    }

    override fun onBackPressed() {}
    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.RadioCheck1 -> {
                    if (checked) {
                        Toast.makeText(this, "91.1 added", Toast.LENGTH_LONG).show()
                        radioChoices.add("91.1")
                    } else {
                        Toast.makeText(this, "91.1 removed", Toast.LENGTH_LONG).show()
                        radioChoices.remove("91.1")
                    }
                }
                R.id.RadioCheck2 -> {
                    if (checked) {
                        radioChoices.add("93.5")
                    } else {
                        radioChoices.remove("93.5")
                    }
                }
                R.id.RadioCheck3 -> {
                    if (checked) {
                        radioChoices.add("94.3")
                    } else {
                        radioChoices.remove("94.3")
                    }
                }
                R.id.RadioCheck4 -> {
                    if (checked) {
                        radioChoices.add("95")
                    } else {
                        radioChoices.remove("95")
                    }
                }
                R.id.RadioCheck5 -> {
                    if (checked) {
                        radioChoices.add("96.7")
                    } else {
                        radioChoices.remove("96.7")
                    }
                }
                R.id.RadioCheck6 -> {
                    if (checked) {
                        radioChoices.add("98.3")
                    } else {
                        radioChoices.remove("98.3")
                    }
                }
                R.id.RadioCheck7 -> {
                    if (checked) {
                        radioChoices.add("104")
                    } else {
                        radioChoices.remove("104")
                    }
                }
            }
        }
    }
}