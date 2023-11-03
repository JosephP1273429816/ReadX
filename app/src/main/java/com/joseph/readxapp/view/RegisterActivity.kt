package com.joseph.readxapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.joseph.readxapp.R
import com.joseph.readxapp.data.TimeUser
import com.joseph.readxapp.data.UserScore

class RegisterActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var errorTextView: TextView
    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        nameEditText = findViewById(R.id.editTextNombre)
        emailEditText = findViewById(R.id.editTextTextEmailAddress)
        passwordEditText = findViewById(R.id.editTextTextPassword)
        registerButton = findViewById(R.id.registrarseccion)
        errorTextView = findViewById(R.id.errorTextView)

        val atrasButton = findViewById<ImageButton>(R.id.botonIrAHomeDos2)
        atrasButton.setOnClickListener {

            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validar el nombre, correo electrónico y la contraseña
            if (!isValidName(name)) {
                errorTextView.text = "El nombre debe tener entre 1 y 12 caracteres"
            } else if (!isValidEmail(email)) {
                errorTextView.text = "Correo electrónico no válido"
            } else if (!isValidPassword(password)) {
                errorTextView.text = "La contraseña debe tener al menos 6 caracteres"
            } else {
                // Registro en Firebase Authentication
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val user = mAuth.currentUser
                            user?.let {
                                val userData = HashMap<String, Any>()
                                userData["name"] = name
                                userData["email"] = email

                                val userId = it.uid // Obtén el UID del usuario

                                // Guardar datos en Firestore
                                db.collection("users")
                                    .document(userId) // Usa el UID del usuario
                                    .set(userData)
                                    .addOnSuccessListener {
                                        // Datos de usuario guardados con éxito

                                        // Crear un documento de puntaje para el usuario recién registrado
                                        val initialScore = UserScore() // Utiliza los valores iniciales del data class
                                        db.collection("scores")
                                            .document(userId) // Usa el UID del usuario
                                            .set(initialScore)
                                            .addOnSuccessListener {
                                                // Documento de puntaje creado con éxito
                                            }
                                            .addOnFailureListener { e ->
                                                // Error al crear el documento de puntaje
                                            }

                                        // Crear un documento de TimeUser para el usuario recién registrado
                                        val initialTimeUser = TimeUser() // Utiliza los valores iniciales del data class
                                        db.collection("TimeUser")
                                            .document(userId) // Usa el UID del usuario
                                            .set(initialTimeUser)
                                            .addOnSuccessListener {
                                                // Documento TimeUser creado con éxito

                                                // Redirigir al usuario a la pantalla de inicio (home)
                                                val intent = Intent(this, Home::class.java)
                                                startActivity(intent)
                                                finish() // Finalizar la actividad actual
                                            }
                                            .addOnFailureListener { e ->
                                                // Error al crear el documento de TimeUser
                                            }
                                    }
                                    .addOnFailureListener { e ->
                                        // Error al guardar datos de usuario en Firestore
                                        errorTextView.text = "Error al guardar datos"
                                    }
                            }
                        } else {
                            // Error en el registro de Firebase Authentication
                            errorTextView.text = "Error al registrar el usuario"
                        }
                    }
            }
        }
    }

    private fun isValidName(name: String): Boolean {
        return name.length in 1..12
    }

    private fun isValidEmail(email: String): Boolean {

        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {

        return password.length >= 6
    }
}
