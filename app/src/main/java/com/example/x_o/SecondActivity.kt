package com.example.x_o

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var firstView: TextView
    private lateinit var secondView: TextView
    private lateinit var winnerText: TextView
    private lateinit var restartButton: Button

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button

    private var i = 0
    private var finished: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        restartButton = findViewById(R.id.restart)


        firstView = findViewById(R.id.firstView)
        secondView = findViewById(R.id.secondView)
        winnerText = findViewById(R.id.winner)

        val extras = intent.extras

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        restartButton.setOnClickListener() {
            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
            winnerText.text = ""
            finished = false
            button1.setBackgroundColor(Color.rgb(200, 200, 200))
            button2.setBackgroundColor(Color.rgb(200, 200, 200))
            button3.setBackgroundColor(Color.rgb(200, 200, 200))
            button4.setBackgroundColor(Color.rgb(200, 200, 200))
            button5.setBackgroundColor(Color.rgb(200, 200, 200))
            button6.setBackgroundColor(Color.rgb(200, 200, 200))
            button7.setBackgroundColor(Color.rgb(200, 200, 200))
            button8.setBackgroundColor(Color.rgb(200, 200, 200))
            button9.setBackgroundColor(Color.rgb(200, 200, 200))
            i = 0


        }

        if (extras != null) {
            firstView.text = extras.getString("FIRST_NAME", "")
            secondView.text = extras.getString("SECOND_NAME", "")
        }

    }

    fun addClick(view: View) {


        if (view is Button && i % 2 == 0 && !finished) {
            if (view.text != "X" && view.text != "O") {

                view.text = "X"
                view.setTextColor(Color.BLACK)
                i += 1
                view.setBackgroundColor(Color.RED)
            }


        } else if (view is Button && i % 2 != 0 && !finished) {
            if (view.text != "X" && view.text != "O") {

                view.text = "O"
                i += 1
                view.setTextColor(Color.BLACK)
                view.setBackgroundColor(Color.YELLOW)

            }
        }


        if (button1.text != "" && button2.text != "" && button3.text != "" && button4.text != "" && button5.text != "" &&
            button6.text != "" && button7.text != "" && button8.text != "" && button9.text != "" && !finished
        ) {
            winnerText.text = "No Winner. Try Again :)"


        }

        if (button1.text == button2.text && button2.text == button3.text && button1.text != "" ||
            button4.text == button5.text && button5.text == button6.text && button4.text != "" ||
            button7.text == button8.text && button8.text == button9.text && button7.text != "" ||
            button1.text == button4.text && button4.text == button7.text && button1.text != "" ||
            button2.text == button5.text && button5.text == button8.text && button2.text != "" ||
            button3.text == button6.text && button6.text == button9.text && button3.text != "" ||
            button1.text == button5.text && button5.text == button9.text && button1.text != "" ||
            button3.text == button5.text && button5.text == button7.text && button3.text != ""
            && !finished
        ) {
            val winnerName: String

            if (i % 2 != 0) {
                winnerName = firstView.text.toString()
                winnerText.text = "$winnerName WIN!"
            } else {
                winnerName = secondView.text.toString()
                winnerText.text = "$winnerName WIN!"
            }
            finished = true


        }
    }
}