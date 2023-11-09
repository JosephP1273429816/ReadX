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
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.joseph.readxapp.data.TimeTracker

class SettingsFragment : Fragment() {
    private val timeTracker: TimeTracker by lazy { TimeTracker.getInstance(requireContext()) }
    private lateinit var logoutButton: Button
    private lateinit var deleteAccountButton: Button
    private lateinit var soporteButton: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    private lateinit var db: FirebaseFirestore
    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.settings_activity, container, false)
        db = FirebaseFirestore.getInstance()
        mAuth = FirebaseAuth.getInstance()

        val cambiarNameButton = rootView.findViewById<Button>(R.id.cambiarName)
        cambiarNameButton.setOnClickListener {
            showPasswordDialog()
        }

        val btnCreditos = rootView.findViewById<Button>(R.id.creditos)
        btnCreditos.setOnClickListener {
            showCreditosDialog()
        }

        val btnResetPassword = rootView.findViewById<Button>(R.id.RestablecerContraseña)
        btnResetPassword.setOnClickListener {
            val email = FirebaseAuth.getInstance().currentUser?.email

            if (!email.isNullOrEmpty()) {
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(requireContext(), "Se ha enviado un correo para restablecer la contraseña a $email", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(requireContext(), "Error al enviar el correo para restablecer la contraseña", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(requireContext(), "No se pudo obtener el correo del usuario actual", Toast.LENGTH_SHORT).show()
            }
        }

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
            showLogoutConfirmationDialog()
        }

        logoutButton.setOnClickListener {
            showLogoutConfirmationDialog()
        }

        deleteAccountButton.setOnClickListener {
            showConfirmationDialog()
        }

        return rootView
    }

    private fun showPasswordDialog() {
        // Crea un AlertDialog para solicitar la contraseña al usuario
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Ingresa tu contraseña")

        // Configura un EditText para la entrada de la contraseña
        val input = EditText(requireContext())
        input.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        builder.setView(input)

        // Configura los botones del AlertDialog
        builder.setPositiveButton("OK") { dialog, which ->
            val password = input.text.toString()

            // Verifica la contraseña aquí antes de permitir que el usuario cambie el nombre
            val user = mAuth.currentUser

            if (user != null) {
                val userEmail = user.email

                if (userEmail != null) {
                    // Reautentica al usuario
                    val credential = EmailAuthProvider.getCredential(userEmail, password)
                    user.reauthenticate(credential)
                        .addOnCompleteListener { reauthTask ->
                            if (reauthTask.isSuccessful) {
                                // La reautenticación fue exitosa, ahora puedes permitir al usuario cambiar su nombre
                                showNameDialog()
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

        builder.setNegativeButton("Cancelar") { dialog, which -> dialog.cancel() }

        builder.show()
    }


    private fun showNameDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Ingresa tu nuevo nombre")

        val input = EditText(requireContext())
        builder.setView(input)

        builder.setPositiveButton("OK") { dialog, which ->
            val newUserName = input.text.toString()
            val userId = mAuth.currentUser?.uid
            val userRef = db.collection("users").document(userId!!)
            userRef.update("name", newUserName)
            val scoreUserRef = db.collection("scoreuser").document(userId)
            scoreUserRef.update("name", newUserName)
        }

        builder.setNegativeButton("Cancelar") { dialog, which -> dialog.cancel() }

        builder.show()
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
            auth.signOut()
            val intent = Intent(requireContext(), login::class.java)
            startActivity(intent)
            requireActivity().finish()
            dialog.dismiss()
        }

        builder.setNegativeButton("No") { dialog, _ ->
            dialog.cancel()
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun showCreditosDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setMessage("Créditos del desarrollo de la aplicación ReadX:\n" +
                "---------------------------------------------\n" +
                "Desarrollador Principal: Joseph\n" +
                "Revisión de Documentos: Sergio\n" +
                "Búsqueda de Contenido: Miguel\n" +
                "Generación de Ideas: Jeison\n" +
                "\n" +
                "Agradecemos sinceramente a nuestro Destacado Desarrollador Principal, Joseph, por su incansable esfuerzo y creatividad. Su liderazgo y visión fueron la piedra angular en la construcción de esta aplicación. Su dedicación incansable y compromiso con la excelencia han allanado el camino para ofrecer un producto excepcional a nuestros usuarios.\n" +
                "\n" +
                "El papel de Sergio en la Revisión de Documentos fue crucial para garantizar la precisión y calidad de nuestra biblioteca. Sus minuciosas revisiones y perfeccionismo han perfeccionado nuestra plataforma, brindando a los usuarios la confianza de que están accediendo a contenido de alta calidad.\n" +
                "\n" +
                "Miguel, el experto en la Búsqueda de Contenido, desempeñó un papel fundamental al curar y seleccionar las joyas literarias que hacen que nuestra aplicación sea única. Su pasión por la literatura ha enriquecido la experiencia de nuestros usuarios y ha abierto las puertas a un mundo de conocimiento y entretenimiento.\n" +
                "\n" +
                "Jeison, nuestro visionario de Generación de Ideas, ha sido el motor detrás de la innovación en cada aspecto de la aplicación Read. Sus conceptos vanguardistas y su habilidad para anticipar las necesidades de nuestros usuarios han dejado una huella imborrable en nuestro producto, lo que lo hace más atractivo y funcional.\n" +
                "\n" +
                "Extendemos nuestro más sincero agradecimiento a todo el equipo que ha contribuido al éxito de la aplicación Read. Cada uno de ustedes ha desempeñado un papel esencial en esta emocionante travesía. Su arduo trabajo, pasión y dedicación son la fuerza impulsora detrás de nuestra misión de brindar una experiencia de lectura excepcional a millones de usuarios en todo el mundo.\n" +
                "\n" +
                "Gracias a su colaboración, hemos logrado un producto que es mucho más que una simple aplicación; es una puerta de entrada a un universo de conocimiento, imaginación y entretenimiento. La aplicación Read ha sido moldeada por sus talentos individuales y la sinergia de su trabajo en equipo, y estamos emocionados por el viaje que aún está por venir.\n" +
                "\n" +
                "¡Descarga la aplicación ReadX y únete a nosotros para disfrutar de una lectura sin límites y descubrir un mundo de posibilidades literarias!"
        )

        builder.setPositiveButton("Cerrar") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun verifyPasswordAndDeleteAccount(password: String) {
        val user = auth.currentUser

        if (user != null) {
            val userEmail = user.email

            if (userEmail != null) {
                val credential = EmailAuthProvider.getCredential(userEmail, password)
                user.reauthenticate(credential)
                    .addOnCompleteListener { reauthTask ->
                        if (reauthTask.isSuccessful) {
                            val userId = user.uid
                            val usersDocRef = firestore.collection("users").document(userId)
                            val timeUserDocRef = firestore.collection("TimeUser").document(userId)
                            val scoresDocRef = firestore.collection("scores").document(userId)

                            usersDocRef.delete()
                                .addOnCompleteListener { deleteUserTask ->
                                    if (deleteUserTask.isSuccessful) {
                                        timeUserDocRef.delete()
                                            .addOnCompleteListener { deleteTimeUserTask ->
                                                if (deleteTimeUserTask.isSuccessful) {
                                                    scoresDocRef.delete()
                                                        .addOnCompleteListener { deleteScoresTask ->
                                                            if (deleteScoresTask.isSuccessful) {
                                                                user.delete()
                                                                    .addOnCompleteListener { deleteAccountTask ->
                                                                        if (deleteAccountTask.isSuccessful) {
                                                                            showSuccessMessage("Cuenta eliminada con éxito. Vuelva pronto.")
                                                                            val intent = Intent(requireContext(), login::class.java)
                                                                            startActivity(intent)
                                                                            requireActivity().finish()
                                                                        } else {
                                                                            showError("Error al eliminar la cuenta: ${deleteAccountTask.exception?.message}")
                                                                        }
                                                                    }
                                                            } else {
                                                                showError("Error al eliminar el documento 'scores': ${deleteScoresTask.exception?.message}")
                                                            }
                                                        }
                                                } else {
                                                    showError("Error al eliminar el documento 'TimeUser': ${deleteTimeUserTask.exception?.message}")
                                                }
                                            }
                                    } else {
                                        showError("Error al eliminar el documento 'users': ${deleteUserTask.exception?.message}")
                                    }
                                }
                        } else {
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gifImageView = view.findViewById<ImageView>(R.id.imageView5)
        Glide.with(this)
            .load(R.drawable.configuracion)
            .into(gifImageView)
    }

    override fun onStart() {
        super.onStart()
        timeTracker.startTrackingTime()
    }

    override fun onStop() {
        super.onStop()
        timeTracker.stopTrackingTime()
    }
}

