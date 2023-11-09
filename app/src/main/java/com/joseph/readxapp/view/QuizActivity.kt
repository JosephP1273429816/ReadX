package com.joseph.readxapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.joseph.readxapp.R
import android.os.Handler
import com.joseph.readxapp.data.Question
import com.joseph.readxapp.data.QuestionData
import java.util.*
import com.joseph.readxapp.data.TimeTracker

class QuizActivity : AppCompatActivity() {
    private val timeTracker: TimeTracker by lazy { TimeTracker.getInstance(this) }
    private lateinit var questionTextView: TextView
    private lateinit var textTextView: TextView
    private lateinit var answerButton1: Button
    private lateinit var answerButton2: Button
    private lateinit var answerButton3: Button
    private lateinit var timerProgressBar: ProgressBar
    private lateinit var timerTextView: TextView

    private lateinit var questionList: List<Question>
    private var currentQuestionIndex = 0
    private var score = 0

    private lateinit var countDownTimer: CountDownTimer
    private val countdownInterval: Long = 1000
    private val totalMilliseconds: Long = 210000

    private val random = Random()
    private val selectedQuestions: MutableList<Question> = mutableListOf()
    private var isQuestionAnswered = false

    private var startTime: Long = 0
    private var uid: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz)

        questionTextView = findViewById(R.id.questionTextView)
        textTextView = findViewById(R.id.textTextView)
        answerButton1 = findViewById(R.id.answerButton1)
        answerButton2 = findViewById(R.id.answerButton2)
        answerButton3 = findViewById(R.id.answerButton3)
        timerProgressBar = findViewById(R.id.timerProgressBar)
        timerTextView = findViewById(R.id.timerTextView)

        // Obtiene todas las preguntas del array QuestionData
        questionList = QuestionData.questionList

        if (questionList.isNotEmpty()) {
            // Selecciona 10 preguntas al azar
            selectRandomQuestions(10)

            // Comienza mostrando la primera pregunta
            displayQuestion(selectedQuestions[currentQuestionIndex])
        } else {
            // No se pudieron cargar las preguntas
        }

        startTime = System.currentTimeMillis()
    }

    override fun onBackPressed() {
        if (!isQuestionAnswered) {
            showExitConfirmationDialog()
        } else {
            super.onBackPressed() // Permite que la actividad se cierre si una pregunta ha sido respondida
        }
    }

    private fun showExitConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmación de salida")
        builder.setMessage("¿Está seguro de que desea salir de la actividad? El progreso se perderá.")

        builder.setPositiveButton("Sí") { dialog, _ ->
            finish() // Cierra la actividad
            dialog.dismiss()
        }

        builder.setNegativeButton("No") { dialog, _ ->
            dialog.cancel()
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun displayQuestion(question: Question) {
        // Restablece los colores de los botones a la normalidad
        answerButton1.setBackgroundResource(R.drawable.botton)
        answerButton2.setBackgroundResource(R.drawable.botton)
        answerButton3.setBackgroundResource(R.drawable.botton)

        questionTextView.text = question.question
        textTextView.text = question.text

        val answers = question.answers
        answerButton1.text = answers[0]
        answerButton2.text = answers[1]
        answerButton3.text = answers[2]

        // Habilita los botones
        answerButton1.isEnabled = true
        answerButton2.isEnabled = true
        answerButton3.isEnabled = true

        answerButton1.setOnClickListener { checkAnswer(0, question.correctAnswer) }
        answerButton2.setOnClickListener { checkAnswer(1, question.correctAnswer) }
        answerButton3.setOnClickListener { checkAnswer(2, question.correctAnswer) }

        startTimer()
    }
    private fun showMessage(message: String, durationMillis: Long = 2000) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
        builder.setPositiveButton("Aceptar") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()

        // Ocultar el mensaje después de la duración especificada
        Handler().postDelayed({
            dialog.dismiss()
        }, durationMillis)
    }

    private val funnyMessagesCorrect = listOf(
        "¡Has sacado tu lado genio! ¿Dónde lo tenías escondido?",
        "Eres tan brillante que hasta el sol necesita gafas de sol para mirarte.",
        "Si fueras una estrella, brillarías más que el universo.",
        "¡Así se hace! ¡Eres como una enciclopedia ambulante!",
        "Tu inteligencia me deja sin palabras. ¡Bien hecho!",
        "Eres la razón por la que las reglas del juego se inventaron. ¡Imposible de superar!",
        "No hay duda, eres un verdadero conocedor. ¡Sigue así!",
        "Tienes más conocimiento en tu meñique que la mayoría de las personas en su cerebro.",
        "¡Eres el Einstein del siglo XXI! O bueno, algo así...",
        "No tengo palabras para tu brillantez. ¡Sigues sorprendiéndome!",
        "Eres como Google en forma humana. ¡Impresionante!",
        "¿Eres una máquina de conocimiento? Porque tus respuestas son impecables.",
        "Si la inteligencia fuera una moneda, estarías nadando en oro.",
        "Nadie se acerca a tu nivel de sabiduría. ¡Eres un auténtico gurú!",
        "Tus respuestas son tan acertadas que podrías predecir el futuro. ¿Eres un vidente?",
        "La sabiduría fluye a través de tus venas. ¡Eres un prodigio!",
    )

    private val funnyMessagesIncorrect = listOf(
        "¡Ups! Parece que confundiste tus neuronas.",
        "No hay problema, todos cometemos errores. ¡Inténtalo de nuevo!",
        "Eso fue interesante... ¿tienes alguna idea de lo que estás haciendo?",
        "Podría jurar que estás jugando a adivinar las respuestas. 😄",
        "Tu nivel de conocimiento es tan avanzado que hasta los expertos se confunden contigo.",
        "Tus respuestas son tan únicas que ni siquiera Google puede encontrarlas.",
        "Si alguien está buscando respuestas incorrectas, eres su héroe.",
        "¡Más cerca del equador y podrías ser el Polo Norte! 😅",
        "Definitivamente tienes un don para la creatividad en tus respuestas.",
        "Tus respuestas son tan originales que hasta los libros de texto se sienten obsoletos.",
        "¡Un día tu mente se descifrará como el Código Da Vinci! 😉",
        "Tienes un talento innato para encontrar respuestas que nadie más podría imaginar.",
        "Si alguna vez se crea un concurso de respuestas únicas, seguro ganarías.",
        "Tus respuestas son tan sorprendentes que los científicos quieren estudiar tu cerebro.",
        "Estás desafiando la lógica en cada respuesta. ¡Nadie puede predecir lo que dirás a continuación!",
    )

    private fun checkAnswer(selectedAnswerIndex: Int, correctAnswerIndex: Int) {
        countDownTimer.cancel()

        // Deshabilita los botones después de responder
        answerButton1.isEnabled = false
        answerButton2.isEnabled = false
        answerButton3.isEnabled = false

        isQuestionAnswered = true  // Marca la pregunta como respondida

        if (selectedAnswerIndex == correctAnswerIndex) {
            score++
            when (correctAnswerIndex) {
                0 -> answerButton1.setBackgroundResource(R.drawable.good_pressed)
                1 -> answerButton2.setBackgroundResource(R.drawable.good_pressed)
                2 -> answerButton3.setBackgroundResource(R.drawable.good_pressed)
            }
            val randomMessage = funnyMessagesCorrect.random()
            showMessage(randomMessage)
        } else {

            val randomMessage = funnyMessagesIncorrect.random()
            showMessage(randomMessage)

            answerButton1.setBackgroundResource(R.drawable.bad_pressed)
            answerButton2.setBackgroundResource(R.drawable.bad_pressed)
            answerButton3.setBackgroundResource(R.drawable.bad_pressed)

            when (correctAnswerIndex) {
                0 -> answerButton1.setBackgroundResource(R.drawable.good_normal)
                1 -> answerButton2.setBackgroundResource(R.drawable.good_normal)
                2 -> answerButton3.setBackgroundResource(R.drawable.good_normal)
            }
        }

        val handler = android.os.Handler()
        handler.postDelayed({
            currentQuestionIndex++
            isQuestionAnswered = false  // Reinicia el estado de la pregunta
            if (currentQuestionIndex < selectedQuestions.size) {
                displayQuestion(selectedQuestions[currentQuestionIndex])
            } else {
                showFinalScore()
            }
        }, 2000)
    }

    private fun showFinalScore() {
        // Registra el tiempo de uso al terminar la actividad
        if (uid != null) {
            val endTime = System.currentTimeMillis()
            val activityElapsedTime = endTime - startTime

        }

        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("score", score) // Pasa el puntaje actual a la actividad de puntuación
        score = 0 // Reinicia el puntaje
        startActivity(intent)
        finish()
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(totalMilliseconds, countdownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                val progress = (millisUntilFinished / 1000).toInt()
                timerProgressBar.progress = progress

                val minutes = progress / 60
                val seconds = progress % 60
                val timeString = String.format("%02d:%02d", minutes, seconds)
                timerTextView.text = timeString
            }

            override fun onFinish() {
                val correctAnswerIndex = selectedQuestions[currentQuestionIndex].correctAnswer
                when (correctAnswerIndex) {
                    0 -> answerButton1.setBackgroundResource(R.drawable.good_pressed)
                    1 -> answerButton2.setBackgroundResource(R.drawable.good_pressed)
                    2 -> answerButton3.setBackgroundResource(R.drawable.good_pressed)
                }

                // Deshabilita los botones después de que el tiempo ha expirado
                answerButton1.isEnabled = false
                answerButton2.isEnabled = false
                answerButton3.isEnabled = false

                val handler = android.os.Handler()
                handler.postDelayed({
                    currentQuestionIndex++
                    isQuestionAnswered = false  // Reinicia el estado de la pregunta
                    if (currentQuestionIndex < selectedQuestions.size) {
                        displayQuestion(selectedQuestions[currentQuestionIndex])
                    } else {
                        showFinalScore()
                    }
                    // Habilita los botones después de un retraso (ejemplo: 2000 ms)
                    handler.postDelayed({
                        answerButton1.isEnabled = true
                        answerButton2.isEnabled = true
                        answerButton3.isEnabled = true
                    }, 2000)
                }, 2000)
            }
        }.start()
    }

    private fun selectRandomQuestions(count: Int) {
        val totalQuestions = questionList.size

        if (count >= totalQuestions) {
            selectedQuestions.addAll(questionList)
        } else {
            while (selectedQuestions.size < count) {
                val randomIndex = random.nextInt(totalQuestions)
                val randomQuestion = questionList[randomIndex]
                if (!selectedQuestions.contains(randomQuestion)) {
                    selectedQuestions.add(randomQuestion)
                }
            }
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


