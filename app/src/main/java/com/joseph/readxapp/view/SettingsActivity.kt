package com.joseph.readxapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.joseph.readxapp.R
import android.app.AlertDialog
import android.text.InputType
import android.widget.EditText
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
            // Mostrar un diálogo de confirmación antes de cerrar sesión
            showLogoutConfirmationDialog()
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

            if (password.isNotEmpty()) {
                // Verificar la contraseña y proceder con la eliminación de la cuenta
                verifyPasswordAndDeleteAccount(password)
                dialog.dismiss()
            } else {
                showError("Por favor, ingresa tu contraseña.")
            }
        }

        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun showLogoutConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmar cierre de sesión")
        builder.setMessage("¿Está seguro de que desea cerrar la sesión?")

        builder.setPositiveButton("Sí") { dialog, _ ->
            // Cerrar la sesión del usuario actual
            auth.signOut()
            // Redirigir al usuario a la pantalla de inicio de sesión
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish() // Cierra la actividad actual
            dialog.dismiss()
        }

        builder.setNegativeButton("No") { dialog, _ ->
            dialog.cancel()
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun verifyPasswordAndDeleteAccount(password: String) {
        val user = auth.currentUser

        if (user != null) {
            val userEmail = user.email

            if (userEmail != null) {
                // Reautenticar al usuario
                val credential = EmailAuthProvider.getCredential(userEmail, password)
                user.reauthenticate(credential)
                    .addOnCompleteListener { reauthTask ->
                        if (reauthTask.isSuccessful) {
                            // La reautenticación fue exitosa, ahora puedes eliminar la cuenta
                            val userId = user.uid

                            val usersDocRef = firestore.collection("users").document(userId)
                            val timeUserDocRef = firestore.collection("TimeUser").document(userId)
                            val scoresDocRef = firestore.collection("scores").document(userId)

                            // Borrar los documentos en Firestore
                            usersDocRef.delete()
                                .addOnCompleteListener { deleteUserTask ->
                                    if (deleteUserTask.isSuccessful) {
                                        timeUserDocRef.delete()
                                            .addOnCompleteListener { deleteTimeUserTask ->
                                                if (deleteTimeUserTask.isSuccessful) {
                                                    scoresDocRef.delete()
                                                        .addOnCompleteListener { deleteScoresTask ->
                                                            if (deleteScoresTask.isSuccessful) {
                                                                // Todos los documentos se han eliminado con éxito
                                                                user.delete()
                                                                    .addOnCompleteListener { deleteAccountTask ->
                                                                        if (deleteAccountTask.isSuccessful) {
                                                                            // La cuenta se ha eliminado exitosamente
                                                                            showSuccessMessage("Cuenta eliminada con éxito. Vuelva pronto.")
                                                                            // Redirigir al usuario a la pantalla de inicio de sesión
                                                                            val intent = Intent(this, login::class.java)
                                                                            startActivity(intent)
                                                                            finish() // Cierra la actividad actual
                                                                        } else {
                                                                            // Ocurrió un error al eliminar la cuenta
                                                                            showError("Error al eliminar la cuenta: ${deleteAccountTask.exception?.message}")
                                                                        }
                                                                    }
                                                            } else {
                                                                // Error al eliminar el documento "scores"
                                                                showError("Error al eliminar el documento 'scores': ${deleteScoresTask.exception?.message}")
                                                            }
                                                        }
                                                } else {
                                                    // Error al eliminar el documento "TimeUser"
                                                    showError("Error al eliminar el documento 'TimeUser': ${deleteTimeUserTask.exception?.message}")
                                                }
                                            }
                                    } else {
                                        // Error al eliminar el documento "users"
                                        showError("Error al eliminar el documento 'users': ${deleteUserTask.exception?.message}")
                                    }
                                }
                        } else {
                            // Ocurrió un error al reautenticar al usuario (contraseña incorrecta)
                            showError("Error al reautenticar al usuario: ${reauthTask.exception?.message}")
                        }
                    }
            } else {
                showError("El correo electrónico del usuario es nulo.")
            }
        } else {
            showError("El usuario no está autenticado.")
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
