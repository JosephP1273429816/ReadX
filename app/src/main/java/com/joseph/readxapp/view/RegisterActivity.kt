package com.joseph.readxapp.view

import com.joseph.readxapp.R
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class RegisterActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        mAuth = FirebaseAuth.getInstance()
        emailEditText = findViewById(R.id.editTextTextEmailAddress)
        passwordEditText = findViewById(R.id.editTextTextPassword)
        registerButton = findViewById(R.id.registrarseccion)

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Registro exitoso
                        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                        // Puedes redirigir al usuario a la actividad de inicio de sesión u otra actividad aquí
                    } else {
                        // El registro falló
                        val exception = task.exception
                        if (exception is FirebaseAuthInvalidCredentialsException) {
                            Toast.makeText(this, "Credenciales incorrectas. Asegúrate de que la contraseña sea válida y el correo electrónico esté en el formato correcto.", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this, "Error al registrar. Inténtalo más tarde.", Toast.LENGTH_LONG).show()
                        }
                    }
                }
        }
    }
}
