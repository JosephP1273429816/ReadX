package com.joseph.readxapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.joseph.readxapp.R
import com.joseph.readxapp.view.login
import android.app.AlertDialog
import android.text.InputType
import android.widget.EditText
import com.google.firebase.auth.EmailAuthProvider
import com.joseph.readxapp.data.TimeTracker

class SettingsActivity : AppCompatActivity() {

    private val timeTracker: TimeTracker by lazy { TimeTracker.getInstance(this) }
    private lateinit var logoutButton: Button
    private lateinit var deleteAccountButton: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        logoutButton = findViewById(R.id.logoutButton)
        deleteAccountButton = findViewById(R.id.deleteAccountButton)

        logoutButton.setOnClickListener {
            // Cerrar la sesión del usuario actual
            auth.signOut()
            // Redirigir al usuario a la pantalla de inicio de sesión
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish() // Cierra la actividad actual
        }

        deleteAccountButton.setOnClickListener {
            // Mostrar un diálogo de confirmación que solicita la contraseña
            showConfirmationDialog()
        }

        // Agregar OnClickListener para el botón de regresar a la pantalla de inicio
        val botonIrAHome = findViewById<ImageButton>(R.id.botonIrAHomeDos)
        botonIrAHome.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }

    private fun showSuccessMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmar eliminación de cuenta")
        builder.setMessage("Por favor, ingrese su contraseña para confirmar la eliminación de la cuenta.")

        val input = EditText(this)
        input.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
        builder.setView(input)

        builder.setPositiveButton("Confirmar") { dialog, _ ->
            val password = input.text.toString()
            // Verificar la contraseña y proceder con la eliminación de la cuenta
            verifyPasswordAndDeleteAccount(password)
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun verifyPasswordAndDeleteAccount(password: String) {
        // Resto del código para eliminar la cuenta (ya proporcionado en tu código anterior)
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
