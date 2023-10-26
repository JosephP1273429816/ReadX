package com.joseph.readxapp.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.joseph.readxapp.R

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rankin)

        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)

        // Obtiene el puntaje del intent que se envió desde QuizActivity
        val score = intent.getIntExtra("score", 0)

        // Muestra el puntaje en el TextView
        scoreTextView.text = "Tu puntaje es: $score"
    }
}
