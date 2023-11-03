package com.joseph.readxapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.joseph.readxapp.R

class login : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var resetPasswordButton: Button
    private lateinit var errorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        mAuth = FirebaseAuth.getInstance()
        emailEditText = findViewById(R.id.editTextTextEmailAddress)
        passwordEditText = findViewById(R.id.editTextTextPassword)
        loginButton = findViewById(R.id.iniciarseccion)
        registerButton = findViewById(R.id.registrarseccion)
        resetPasswordButton = findViewById(R.id.resetPasswordButton)
        errorTextView = findViewById(R.id.errorTextView)

        // Verifica si el usuario ya ha iniciado sesión
        if (mAuth.currentUser != null) {
            // El usuario ya ha iniciado sesión, redirige a la pantalla "home"
            startActivity(Intent(this, Home::class.java))
            finish()
        }

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                errorTextView.text = "Por favor, ingresa tu correo y contraseña."
            } else {
                mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Inicio de sesión exitoso
                            val user = mAuth.currentUser
                            // Redirige a la actividad "home"
                            startActivity(Intent(this, Home::class.java))
                            finish()
                        } else {
                            // El inicio de sesión falló
                            val exception = task.exception
                            if (exception is FirebaseAuthInvalidCredentialsException) {
                                errorTextView.text = "Credenciales incorrectas. Inténtalo de nuevo."
                            } else {
                                errorTextView.text = "Error al iniciar sesión. Inténtalo más tarde."
                            }
                        }
                    }
            }
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)

            // Iniciar la actividad de registro
            startActivity(intent)
        }

        resetPasswordButton.setOnClickListener {
            val email = emailEditText.text.toString()

            if (email.isEmpty()) {
                errorTextView.text = "Por favor, ingresa tu correo electrónico."
            } else {
                mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            errorTextView.text = "Se ha enviado un correo para restablecer la contraseña."
                        } else {
                            val exception = task.exception
                            if (exception is FirebaseAuthInvalidCredentialsException) {
                                errorTextView.text = "Correo electrónico inválido. Introduce un correo válido."
                            } else {
                                errorTextView.text = "Error al enviar el correo de restablecimiento de contraseña."
                            }
                        }
                    }
            }
        }
    }
}
