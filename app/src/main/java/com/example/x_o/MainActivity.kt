package com.example.x_o

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var firstPlayer: EditText
    private lateinit var secondPlayer: EditText
    private lateinit var playButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstPlayer = findViewById(R.id.First)
        secondPlayer = findViewById(R.id.Secod)
        playButton = findViewById(R.id.playButton)

        playButton.setOnClickListener(){
            val firstName = firstPlayer.text.toString()
            val secondName = secondPlayer.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("FIRST_NAME", firstName)
            intent.putExtra("SECOND_NAME", secondName)

            startActivity(intent)



        }

    }
}