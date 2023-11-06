package com.joseph.readxapp.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
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
    private lateinit var terminosButton: Button
    private lateinit var errorTextView: TextView
    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private lateinit var showPasswordToggle: ImageView
    private lateinit var checkBox: CheckBox

    private var passwordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        nameEditText = findViewById(R.id.editTextNombre)
        emailEditText = findViewById(R.id.editTextTextEmailAddress)
        passwordEditText = findViewById(R.id.editTextTextPassword)
        registerButton = findViewById(R.id.registrarseccion)
        terminosButton = findViewById(R.id.TérminosyCondicionesdeUsoBotton)
        errorTextView = findViewById(R.id.errorTextView)
        showPasswordToggle = findViewById(R.id.showPasswordToggle)
        checkBox = findViewById(R.id.checkBox)

        showPasswordToggle.setOnClickListener {
            togglePasswordVisibility()
        }

        val atrasButton = findViewById<ImageButton>(R.id.botonIrAHomeDos2)
        atrasButton.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        terminosButton.setOnClickListener {
            showTermsAndConditionsDialog()
        }

        registerButton.setOnClickListener {
            if (checkBox.isChecked) {
                val name = nameEditText.text.toString()
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    errorTextView.text = "Por favor, completa todos los campos."
                } else {
                    performRegistration()
                }
            } else {
                errorTextView.text = "Debes aceptar los Términos y Condiciones de Uso para registrarte."
            }
        }
    }

    private fun showTermsAndConditionsDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Términos y Condiciones de Uso")
        builder.setMessage("Última actualización: 3/11/2023\n" +
                "\n" +
                "Aviso Legal en Conformidad con la Ley de Protección de Datos de Colombia (Ley 1581 de 2012) y el Decreto Reglamentario (Decreto 1377 de 2013):\n" +
                "\n" +
                "Por favor, lea atentamente estos Términos y Condiciones de Uso antes de utilizar nuestra aplicación móvil ReadX operada por Jpalomino502. Al utilizar la Aplicación, usted acepta cumplir con estos Términos. Si no está de acuerdo con estos Términos, por favor, no utilice la Aplicación.\n" +
                "\n" +
                "1. Privacidad del usuario\n" +
                "Entendemos la importancia de la privacidad de los usuarios y nos comprometemos a protegerla. Al utilizar la Aplicación, usted acepta nuestra Política de Privacidad, que describe cómo recopilamos, utilizamos y compartimos su información personal. Le recomendamos que lea nuestra Política de Privacidad detenidamente.\n" +
                "\n" +
                "2. Registro y cuentas de usuario\n" +
                "Al registrarse en la Aplicación, usted acepta proporcionar información precisa y actualizada. Es su responsabilidad mantener la confidencialidad de su información de inicio de sesión y notificarnos de inmediato cualquier uso no autorizado de su cuenta.\n" +
                "\n" +
                "3. Uso adecuado\n" +
                "Usted se compromete a utilizar la Aplicación de manera adecuada y de conformidad con la legislación aplicable. No está permitido utilizar la Aplicación de manera que cause daño a otros usuarios o que viole sus derechos. Se prohíbe expresamente cualquier actividad ilegal o no autorizada a través de la Aplicación.\n" +
                "\n" +
                "4. Almacenamiento de datos\n" +
                "La Aplicación puede recopilar y almacenar información relacionada con su uso, como correos electrónicos, nombres de usuario y actividad en la aplicación. Esta información se utiliza para mejorar la experiencia del usuario y no será compartida con terceros sin su consentimiento, excepto cuando sea necesario para el funcionamiento de la aplicación.\n" +
                "\n" +
                "5. Cambios en los Términos\n" +
                "Nos reservamos el derecho de modificar estos Términos en cualquier momento. Cualquier modificación se hará efectiva a partir de la fecha de la última actualización indicada al comienzo de estos Términos. Le recomendamos que revise periódicamente estos Términos para estar al tanto de las actualizaciones.\n" +
                "\n" +
                "6. Término y terminación\n" +
                "Estos Términos son efectivos hasta que sean terminados por usted o por nosotros. Usted puede terminar estos Términos al dejar de utilizar la Aplicación. Nosotros podemos terminar estos Términos en cualquier momento si incumple alguno de los términos establecidos en ellos.\n" +
                "\n" +
                "7. Contacto\n" +
                "Si tiene alguna pregunta o inquietud sobre estos Términos, por favor contáctenos a quejasyreclamosreadx@gmail.com.\n" +
                "\n" +
                "Estos Términos y Condiciones de Uso son un acuerdo legal entre usted y ReadX y rigen su uso de la Aplicación. Al utilizar la Aplicación, usted acepta cumplir con estos Términos.\n" +
                "\n" +
                "Gracias por utilizar nuestra Aplicación.\n")

        builder.setPositiveButton("Cerrar") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun togglePasswordVisibility() {
        passwordVisible = !passwordVisible
        if (passwordVisible) {
            passwordEditText.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            showPasswordToggle.setImageResource(R.drawable.ic_visibility_on)
        } else {
            passwordEditText.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            showPasswordToggle.setImageResource(R.drawable.ic_visibility_off)
        }
        passwordEditText.setSelection(passwordEditText.text.length)
    }

    private fun performRegistration() {
        val name = nameEditText.text.toString()
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = mAuth.currentUser
                    user?.let {
                        val userData = HashMap<String, Any>()
                        userData["name"] = name
                        userData["email"] = email

                        val userId = it.uid

                        db.collection("users")
                            .document(userId)
                            .set(userData)
                            .addOnSuccessListener {
                                val initialScore = UserScore(name)
                                db.collection("scores")
                                    .document(userId)
                                    .set(initialScore)
                                    .addOnSuccessListener {
                                        val initialTimeUser = TimeUser()
                                        db.collection("TimeUser")
                                            .document(userId)
                                            .set(initialTimeUser)
                                            .addOnSuccessListener {
                                                val intent = Intent(this, Home::class.java)
                                                startActivity(intent)
                                                finish()
                                            }
                                            .addOnFailureListener { e ->
                                                errorTextView.text = "Error al crear el documento de TimeUser."
                                            }
                                    }
                                    .addOnFailureListener { e ->
                                        errorTextView.text = "Error al crear el documento de puntaje."
                                    }
                            }
                            .addOnFailureListener { e ->
                                errorTextView.text = "Error al guardar datos en Firestore."
                            }
                    }
                } else {
                    errorTextView.text = "Error al registrar el usuario."
                }
            }
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
    }
}
