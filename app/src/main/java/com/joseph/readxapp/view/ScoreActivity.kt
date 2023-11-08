package com.joseph.readxapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.joseph.readxapp.R
import com.joseph.readxapp.data.TimeTracker
import com.joseph.readxapp.data.ScoreManager
import com.google.firebase.auth.FirebaseAuth

class ScoreActivity : AppCompatActivity() {

    private val timeTracker: TimeTracker by lazy { TimeTracker.getInstance(this) }
    private val scoreManager: ScoreManager = ScoreManager()
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.puntaje)

        val botonIrAHome = findViewById<ImageButton>(R.id.botonIrAHomeDos)
        botonIrAHome.setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }

        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        score = intent.getIntExtra("score", 0)
        scoreTextView.text = "Tu puntaje es: $score"
    }

    override fun onStart() {
        super.onStart()

        // Comienza a rastrear el tiempo cuando la actividad comienza
        timeTracker.startTrackingTime()
    }

    override fun onStop() {
        super.onStop()

        // Detiene el rastreo del tiempo cuando la actividad se detiene
        timeTracker.stopTrackingTime()

        // Obtiene el ID de usuario autenticado
        val userId = FirebaseAuth.getInstance().currentUser?.uid

        if (userId != null) {
            // Guarda el puntaje en Firestore utilizando el ScoreManager
            scoreManager.saveGlobalScore(userId, score)
        }
    }
}
