package com.joseph.readxapp.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.joseph.readxapp.R

class SplashScreenActivity : AppCompatActivity() {

    private val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video)

        val videoView = findViewById<VideoView>(R.id.videoView2)
        val videoPath = "android.resource://" + packageName + "/" + R.raw.logovideo

        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = false
            videoView.start()

            val splashScreenDuration = mediaPlayer.duration

            // Verificar si el usuario ha iniciado sesión
            if (firebaseAuth.currentUser != null) {
                // Si el usuario ha iniciado sesión, dirígelo a la actividad principal
                val intent = Intent(this, Inicio::class.java)
                videoView.postDelayed({
                    startActivity(intent)
                    finish()
                }, splashScreenDuration.toLong())
            } else {
                // Si el usuario no ha iniciado sesión, dirígelo a la actividad de inicio de sesión
                val intent = Intent(this, login::class.java)
                videoView.postDelayed({
                    startActivity(intent)
                    finish()
                }, splashScreenDuration.toLong())
            }
        }
    }
}
