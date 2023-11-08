package com.joseph.readxapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.joseph.readxapp.R

class Inicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bar)

        // Cargar el primer fragmento cuando se inicia la actividad
        cargarFragmento(HomeFragment())

        // Configura los clics en el BottomNavigationView para cargar fragmentos
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> cargarFragmento(HomeFragment())
                R.id.navigation_game -> cargarFragmento(QuizOneFragment())
                R.id.navigation_Configuracion -> cargarFragmento(SettingsFragment())
            }
            true
        }
    }

    private fun cargarFragmento(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}

