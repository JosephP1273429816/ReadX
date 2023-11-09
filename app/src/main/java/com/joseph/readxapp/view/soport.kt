package com.joseph.readxapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton
import android.content.Intent
import com.joseph.readxapp.R
import com.bumptech.glide.Glide
import android.widget.ImageView
import android.net.Uri
import com.joseph.readxapp.data.TimeTracker

class soport : AppCompatActivity() {

    private val timeTracker: TimeTracker by lazy { TimeTracker.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.soport)
        val atrasButton = findViewById<ImageButton>(R.id.botonIrAHomeDos)

        // Configura un OnClickListener para el botón "atras"
        atrasButton.setOnClickListener {
            // Inicia la actividad de inicio (HomeActivity)
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }

        val imageView = findViewById<ImageView>(R.id.imageView7)

        // Configura un OnClickListener para el ImageView
        imageView.setOnClickListener {
            // Define la URL que deseas abrir en el navegador
            val url = "https://forms.gle/ZLCm63sR1ztD1NH29" // Cambia esto por la URL que desees

            // Crea una intención para abrir la URL en un navegador
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

            // Inicia la actividad que maneja la intención
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
