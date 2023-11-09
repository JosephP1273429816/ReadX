package com.joseph.readxapp.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.joseph.readxapp.R
import com.joseph.readxapp.data.TimeTracker
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide


class QuizOneFragment : Fragment() {
    private val timeTracker: TimeTracker by lazy { TimeTracker.getInstance(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val rootView = inflater.inflate(R.layout.quiznumberone, container, false)
        val button3 = rootView.findViewById<Button>(R.id.button3)

        button3.setOnClickListener {
            val intent = Intent(requireContext(), QuizActivity::class.java)
            startActivity(intent)
        }

        return rootView
    }

    override fun onStart() {
        super.onStart()

        // Comienza a rastrear el tiempo cuando el fragmento comienza
        timeTracker.startTrackingTime()
    }

    override fun onStop() {
        super.onStop()

        // Detiene el rastreo del tiempo cuando el fragmento se detiene
        timeTracker.stopTrackingTime()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Encuentra la vista ImageView donde deseas mostrar el GIF
        val gifImageView = view.findViewById<ImageView>(R.id.imageView2)

        // Carga el GIF en la ImageView utilizando Glide
        Glide.with(this)
            .load(R.drawable.gamema) // Reemplaza "mi_gif" con el nombre de tu archivo GIF en res/raw
            .into(gifImageView)
    }
}


