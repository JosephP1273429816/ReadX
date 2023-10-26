package com.joseph.readxapp.view

import com.joseph.readxapp.data.Question
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.joseph.readxapp.R
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream

class QuizActivity : AppCompatActivity() {
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
    private val totalMilliseconds: Long = 60000

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

        // Carga las preguntas desde el archivo JSON
        questionList = loadQuestionsFromJson()

        if (questionList.isNotEmpty()) {
            displayQuestion(questionList[currentQuestionIndex])
        } else {
            // No se pudieron cargar las preguntas
        }
    }

    private fun displayQuestion(question: Question) {
        // Restablece los colores de los botones a la normalidad
        answerButton1.setBackgroundColor(resources.getColor(R.color.button_normal))
        answerButton2.setBackgroundColor(resources.getColor(R.color.button_normal))
        answerButton3.setBackgroundColor(resources.getColor(R.color.button_normal))

        questionTextView.text = question.question
        textTextView.text = question.text

        val answers = question.answers
        answerButton1.text = answers[0]
        answerButton2.text = answers[1]
        answerButton3.text = answers[2]

        answerButton1.setOnClickListener { checkAnswer(0, question.correctAnswer) }
        answerButton2.setOnClickListener { checkAnswer(1, question.correctAnswer) }
        answerButton3.setOnClickListener { checkAnswer(2, question.correctAnswer) }

        startTimer()
    }

    private fun checkAnswer(selectedAnswerIndex: Int, correctAnswerIndex: Int) {
        countDownTimer.cancel() // Detener el contador cuando se selecciona una respuesta

        if (selectedAnswerIndex == correctAnswerIndex) {
            // Respuesta correcta
            score++
            answerButton1.setBackgroundColor(resources.getColor(R.color.correct_button_pressed))
            answerButton2.setBackgroundColor(resources.getColor(R.color.correct_button_pressed))
            answerButton3.setBackgroundColor(resources.getColor(R.color.correct_button_pressed))
        } else {
            // Respuesta incorrecta
            answerButton1.setBackgroundColor(resources.getColor(R.color.wrong_button_pressed))
            answerButton2.setBackgroundColor(resources.getColor(R.color.wrong_button_pressed))
            answerButton3.setBackgroundColor(resources.getColor(R.color.wrong_button_pressed))
            // Mostrar la respuesta correcta
            when (correctAnswerIndex) {
                0 -> answerButton1.setBackgroundColor(resources.getColor(R.color.correct_button_normal))
                1 -> answerButton2.setBackgroundColor(resources.getColor(R.color.correct_button_normal))
                2 -> answerButton3.setBackgroundColor(resources.getColor(R.color.correct_button_normal))
            }
        }

        // Espera un momento y luego muestra la siguiente pregunta
        val handler = android.os.Handler()
        handler.postDelayed({
            currentQuestionIndex++
            if (currentQuestionIndex < questionList.size) {
                displayQuestion(questionList[currentQuestionIndex])
            } else {
                showFinalScore()
            }
        }, 2000) // Espera 2 segundos
    }

    private fun showFinalScore() {
        // Crea un Intent para iniciar la actividad de puntuación y pasa el puntaje como extra
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("score", score)
        startActivity(intent)
        finish() // Cierra la actividad actual si no deseas volver atrás
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(totalMilliseconds, countdownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                val progress = (millisUntilFinished / 1000).toInt()
                timerProgressBar.progress = progress
                timerTextView.text = (millisUntilFinished / 1000).toString() // Actualiza el contador de tiempo
            }

            override fun onFinish() {
                // Tiempo agotado, muestra la respuesta correcta
                val correctAnswerIndex = questionList[currentQuestionIndex].correctAnswer
                when (correctAnswerIndex) {
                    0 -> answerButton1.setBackgroundColor(resources.getColor(R.color.correct_button_normal))
                    1 -> answerButton2.setBackgroundColor(resources.getColor(R.color.correct_button_normal))
                    2 -> answerButton3.setBackgroundColor(resources.getColor(R.color.correct_button_normal))
                }

                // Espera un momento y luego muestra la siguiente pregunta
                val handler = android.os.Handler()
                handler.postDelayed({
                    currentQuestionIndex++
                    if (currentQuestionIndex < questionList.size) {
                        displayQuestion(questionList[currentQuestionIndex])
                    } else {
                        showFinalScore()
                    }
                }, 2000) // Espera 2 segundos
            }
        }.start()
    }

    private fun loadQuestionsFromJson(): List<Question> {
        val questions = mutableListOf<Question>()
        try {
            val inputStream: InputStream = resources.openRawResource(R.raw.questions)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, Charsets.UTF_8)

            val jsonArray = JSONArray(json)

            for (i in 0 until jsonArray.length()) {
                val jsonObject: JSONObject = jsonArray.getJSONObject(i)

                val question: String = jsonObject.getString("question")
                val text: String = jsonObject.getString("text")
                val answersArray: JSONArray = jsonObject.getJSONArray("answers")
                val answers = mutableListOf<String>()

                for (j in 0 until answersArray.length()) {
                    answers.add(answersArray.getString(j))
                }
                val correctAnswer: Int = jsonObject.getInt("correctAnswer")

                val quizData = Question(question, text, answers, correctAnswer)
                questions.add(quizData)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return questions
    }
}