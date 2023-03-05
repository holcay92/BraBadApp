package com.example.elephant1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.media.MediaPlayer
class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.yeahscience)
        val clickButton = findViewById<Button>(R.id.btn_click_me)
        val textField = findViewById<TextView>(R.id.tv1)
        val resetButton = findViewById<Button>(R.id.btn_reset)

        var timesClicked = 0

        clickButton.setOnClickListener {
            mediaPlayer?.start()
            timesClicked++
            textField.text = timesClicked.toString()

            if (timesClicked % 3 == 0 && timesClicked % 2 != 0){
                Toast.makeText(this,"Yeah Mr white",Toast.LENGTH_SHORT).show()
            }
            else if (timesClicked % 2 == 0) Toast.makeText(this,"Yes, Science Bitch!",Toast.LENGTH_SHORT).show()

        }
        resetButton.setOnClickListener {
            mediaPlayer?.stop()
            timesClicked=0
            val intent = Intent(this, SayMyName::class.java)
            startActivity(intent)
        }
    }
}