package com.dam2.simonsaysversion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    val MyViewModel by viewModels<MyViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greenButton: Button = findViewById(R.id.green)
        val redButton: Button = findViewById(R.id.red)
        val yellowButton: Button = findViewById(R.id.yellow)
        val blueButton: Button = findViewById(R.id.blue)
        val startButton: Button = findViewById(R.id.start)


        // Functions to activate or disable buttons depending on game state.

        fun disableButtons() {
            greenButton.setEnabled(false)
            yellowButton.setEnabled(false)
            blueButton.setEnabled(false)
            redButton.setEnabled(false)
        }

        fun enableButtons() {
            greenButton.setEnabled(true)
            yellowButton.setEnabled(true)
            blueButton.setEnabled(true)
            redButton.setEnabled(true)
        }

        startButton.setOnClickListener {
            enableButtons()
            MyViewModel.createRoundList()
        }


        //For the buttons we first launch the listener for each of them and then compare if it matches the sequence to follow.

        greenButton.setOnClickListener {
            val b = MyViewModel.saveUserList(0)
            if (MyViewModel.userInterctions == MyViewModel.randomList.size) {
                if (MyViewModel.compareList()) {
                    Toast.makeText(applicationContext,"Nice!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext,"Fail, try again.", Toast.LENGTH_SHORT).show()
                    disableButtons()
                }
            }
        }

        redButton.setOnClickListener {
            MyViewModel.saveUserList(1)
            if (MyViewModel.userInterctions == MyViewModel.randomList.size) {
                if (MyViewModel.compareList()) {
                    Toast.makeText(applicationContext,"Nice!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext,"Fail, try again.", Toast.LENGTH_SHORT).show()
                    disableButtons()
                }
            }
        }

        yellowButton.setOnClickListener {
            MyViewModel.saveUserList(2)
            if (MyViewModel.userInterctions == MyViewModel.randomList.size) {
                if (MyViewModel.compareList()) {
                    Toast.makeText(applicationContext,"Nice!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext,"Fail, try again.", Toast.LENGTH_SHORT).show()
                    disableButtons()
                }
            }
        }

        blueButton.setOnClickListener {
            MyViewModel.saveUserList(3)
            if (MyViewModel.userInterctions == MyViewModel.randomList.size) {
                if (MyViewModel.compareList()) {
                    Toast.makeText(applicationContext,"Nice!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext,"Fail, try again.", Toast.LENGTH_SHORT).show()
                    disableButtons()
                }
            }
        }
    }

}