package com.joseph.readxapp.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import androidx.appcompat.app.AlertDialog
import com.joseph.readxapp.R
import android.text.InputType
import com.joseph.readxapp.data.TimeTracker


class SettingsFragment : Fragment() {
    private val timeTracker: TimeTracker by lazy { TimeTracker.getInstance(requireContext()) }
    private lateinit var logoutButton: Button
    private lateinit var deleteAccountButton: Button
    private lateinit var soporteButton: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.settings_activity, container, false)

        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        soporteButton= rootView.findViewById<Button>(R.id.soporteButton)
        logoutButton = rootView.findViewById(R.id.logoutButton)
        deleteAccountButton = rootView.findViewById(R.id.deleteAccountButton)

        soporteButton.setOnClickListener {
            val intent = Intent(requireContext(), soport::class.java)
            startActivity(intent)
        }


        logoutButton.setOnClickListener {
            // Mostrar un diálogo de confirmación antes de cerrar sesión
            showLogoutConfirmationDialog()
        }

        deleteAccountButton.setOnClickListener {
            // Mostrar un diálogo de confirmación que solicita la contraseña
            showConfirmationDialog()
        }

        // Agregar OnClickListener para el botón de regresar a la pantalla de inicio
        return rootView
    }

    private fun showSuccessMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun showConfirmationDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Confirmar eliminación de cuenta")
        builder.setMessage("Por favor, ingrese su contraseña para confirmar la eliminación de la cuenta.")

        val input = EditText(requireContext())
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
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Confirmar cierre de sesión")
        builder.setMessage("¿Está seguro de que desea cerrar la sesión?")

        builder.setPositiveButton("Sí") { dialog, _ ->
            // Cerrar la sesión del usuario actual
            auth.signOut()
            // Redirigir al usuario a la pantalla de inicio de sesión
            val intent = Intent(requireContext(), login::class.java)
            startActivity(intent)
            requireActivity().finish() // Cierra la actividad actual
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
                                                                            val intent = Intent(requireContext(), login::class.java)
                                                                            startActivity(intent)
                                                                            requireActivity().finish() // Cierra la actividad actual
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

        // Comienza a rastrear el tiempo cuando el fragmento comienza
        timeTracker.startTrackingTime()
    }

    override fun onStop() {
        super.onStop()

        // Detiene el rastreo del tiempo cuando el fragmento se detiene
        timeTracker.stopTrackingTime()
    }
}
