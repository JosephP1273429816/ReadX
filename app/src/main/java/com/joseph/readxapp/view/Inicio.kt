package com.joseph.readxapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.joseph.readxapp.R
import androidx.appcompat.app.AlertDialog


class Inicio : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bar)

        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> cargarFragmento(HomeFragment())
                R.id.navigation_game -> cargarFragmento(QuizOneFragment())
                R.id.navigation_Configuracion -> cargarFragmento(SettingsFragment())
            }
            true
        }

        cargarFragmento(HomeFragment())
    }

    override fun onResume() {
        super.onResume()
        actualizarBarraNavegacion()
    }

    private fun actualizarBarraNavegacion() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        when (currentFragment) {
            is HomeFragment -> bottomNavigation.selectedItemId = R.id.navigation_home
            is QuizOneFragment -> bottomNavigation.selectedItemId = R.id.navigation_game
            is SettingsFragment -> bottomNavigation.selectedItemId = R.id.navigation_Configuracion
        }
    }

    private fun cargarFragmento(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment is HomeFragment) {
            showExitConfirmationDialog()
        } else {
            cargarFragmento(HomeFragment())
            bottomNavigation.selectedItemId = R.id.navigation_home
        }
    }


    private fun showExitConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Salir de la aplicación")
        builder.setMessage("¿Estás seguro de que quieres salir de la aplicación?")
        builder.setPositiveButton("Sí") { _, _ ->
            finish()
        }
        builder.setNegativeButton("No") { _, _ ->
        }
        builder.show()

    }
}

