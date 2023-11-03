package com.joseph.readxapp.view

import android.content.Intent
import com.joseph.readxapp.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageButton
import com.joseph.readxapp.data.TimeTracker

class QuizOne : AppCompatActivity() {
    private val timeTracker: TimeTracker by lazy { TimeTracker.getInstance(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiznumberone)

        val botonIrAHome = findViewById<ImageButton>(R.id.botonIrAHomeDos)
        botonIrAHome.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val button3 = findViewById<Button>(R.id.button3)

        button3.setOnClickListener {


            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
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
    }
}

