package com.example.elephant1

import android.media.MediaPlayer
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class SayMyName : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_say_my_name)

        val playButton = findViewById<Button>(R.id.btn_play)
        val goBackButton = findViewById<Button>(R.id.btn_go_back)

        goBackButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            mediaPlayer?.stop()
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.say)
        playButton.setOnClickListener{
            mediaPlayer?.start()
        }
    }




}