package com.joseph.readxapp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.joseph.readxapp.R
import android.widget.ListView
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.joseph.readxapp.data.TimeTracker
import com.joseph.readxapp.data.TimeUser

class Home : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private val timeTracker: TimeTracker by lazy { TimeTracker.getInstance(this) }
    private var timeUser: TimeUser? = null
    private val TAG = "Home"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val soporteButton = findViewById<Button>(R.id.soporte)
        val ajustesButton = findViewById<Button>(R.id.ajustes)
        val jugarButton = findViewById<Button>(R.id.jugar)
        val bienvenidaTextView = findViewById<TextView>(R.id.bienvenida)
        val promedioTextView = findViewById<TextView>(R.id.promedioTextView)
        val barChart = findViewById<BarChart>(R.id.barChart)

        // Obtén una referencia a tu ListView
        val listView = findViewById<ListView>(R.id.rankingListView)

        // Crea un mapa para almacenar los nombres de usuario y sus puntuaciones
        val userScores = mutableMapOf<String?, Long?>()

        // Oyente en tiempo real para la colección "scores"
        db.collection("scores")
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Log.w(TAG, "Escucha fallida.", e)
                    return@addSnapshotListener
                }

                userScores.clear()

                for (document in snapshots!!) {
                    val userName = document.getString("name")
                    val globalScore = document.getLong("globalScore")
                    userScores[userName] = globalScore
                }

                // Crea una lista para el ArrayAdapter
                val displayList = userScores.toList().sortedByDescending { (_, value) -> value}.mapIndexed { index, pair -> "${index + 1}. ${pair.first}: ${pair.second ?: "N/A"}" }

                // Crear un ArrayAdapter personalizado para utilizar el diseño list_item.xml
                val adapter = ArrayAdapter(this, R.layout.list_item, R.id.list_item_text, displayList)

                // Asigna el ArrayAdapter a tu ListView
                listView.adapter = adapter
            }

        soporteButton.setOnClickListener {
            val intent = Intent(this, soport::class.java)
            startActivity(intent)
        }

        ajustesButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        jugarButton.setOnClickListener {
            val intent = Intent(this, QuizOne::class.java)
            startActivity(intent)
        }

        // Obtiene el UID del usuario actualmente autenticado
        val user = auth.currentUser
        val uid = user?.uid

        // Realiza una consulta a Firestore para obtener el nombre del usuario
        uid?.let { userId ->
            val usersCollection = db.collection("users")
            val userDocument = usersCollection.document(userId)

            userDocument.get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        val nombreUsuario = document.getString("name")
                        if (nombreUsuario != null) {
                            bienvenidaTextView.text = getString(R.string.bienvenido_name, nombreUsuario)
                        } else {
                            bienvenidaTextView.text = "Nombre del Usuario"
                        }
                    } else {
                        bienvenidaTextView.text = "Nombre del Usuario"
                    }
                }
                .addOnFailureListener { e ->
                    bienvenidaTextView.text = "Nombre del Usuario"
                }

            // Configura la gráfica de barras
            barChart.setDrawGridBackground(false) // Quita la cuadrícula de fondo
            val backgroundColor = ContextCompat.getColor(this, R.color.boton)
            barChart.setBackgroundColor(backgroundColor)
            barChart.description.isEnabled = false // Quita la descripción

            // Configura el eje X para mostrar los nombres de los días de la semana
            val xAxis = barChart.xAxis
            xAxis.position = XAxis.XAxisPosition.BOTTOM // Posiciona las etiquetas del eje X en la parte inferior de la gráfica
            xAxis.setDrawGridLines(false) // Quita las líneas de cuadrícula del eje X
            xAxis.textSize = 10f // Cambia el tamaño de la fuente de las etiquetas del eje X

            // Aquí es donde puedes cambiar la fuente a una personalizada
            val typeface = ResourcesCompat.getFont(this, R.font.fonttex)
            xAxis.typeface = typeface
            xAxis.textColor = ContextCompat.getColor(this, R.color.white)


            // Configura el eje Y para que comience en 0
            val yAxisLeft = barChart.axisLeft
            yAxisLeft.axisMinimum = 0f // Establece el valor mínimo del eje Y en 0
            yAxisLeft.textColor = ContextCompat.getColor(this, R.color.white)
            yAxisLeft.textColor = ContextCompat.getColor(this, R.color.white)

            val yAxisRight = barChart.axisRight
            yAxisRight.axisMinimum = 0f // Establece el valor mínimo del eje Y en 0
            yAxisRight.textColor = ContextCompat.getColor(this, R.color.white)


            // Recupera los datos de Firestore para llenar la gráfica de barras
            db.collection("TimeUser").document(userId).get().addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    timeUser = documentSnapshot.toObject(TimeUser::class.java)

                    val entries = ArrayList<BarEntry>()
                    val daysOfWeek = listOf("domingo", "lunes", "martes", "miércoles", "jueves", "viernes", "sábado")

                    // Llena las entradas con los datos de Firestore para cada día de la semana
                    for ((index, day) in daysOfWeek.withIndex()) {
                        val timeInMinutes = when (day) {
                            "domingo" -> timeUser?.domingo ?: 0L
                            "lunes" -> timeUser?.lunes ?: 0L
                            "martes" -> timeUser?.martes ?: 0L
                            "miércoles" -> timeUser?.miércoles ?: 0L
                            "jueves" -> timeUser?.jueves ?: 0L
                            "viernes" -> timeUser?.viernes ?: 0L
                            "sábado" -> timeUser?.sábado ?: 0L
                            else -> 0L
                        }
                        entries.add(BarEntry(index.toFloat(), timeInMinutes.toFloat()))
                    }

                    xAxis.valueFormatter = IndexAxisValueFormatter(listOf("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado")) // Establece las etiquetas del eje X como los días de la semana

                    val dataSet = BarDataSet(entries, "")
                    dataSet.valueTextColor = ContextCompat.getColor(this, R.color.white)
                    dataSet.valueTextSize = 10f
                    dataSet.setDrawValues(true)

                    // Aquí es donde puedes cambiar el color a uno personalizado
                    dataSet.color = ContextCompat.getColor(this, R.color.primarySecond)

                    // Configura el tamaño de la fuente de los valores en las barras
                    dataSet.valueTextSize = 10f
                    dataSet.setDrawValues(true)

                    val data = BarData(dataSet) // Crea los datos para la gráfica a partir del conjunto de datos

                    barChart.data = data // Establece los datos de la gráfica
                    barChart.invalidate() // Redibuja la gráfica con los nuevos datos

                    // Calcular el promedio semanal dividiendo siempre por 7 días
                    val totalWeeklyTime = (timeUser?.lunes ?: 0) +
                            (timeUser?.martes ?: 0) + (timeUser?.miércoles ?: 0) +
                            (timeUser?.jueves ?: 0) + (timeUser?.viernes ?: 0) +
                            (timeUser?.sábado ?: 0) + (timeUser?.domingo ?: 0)

                    val averageWeeklyTime = totalWeeklyTime / 7 // Dividir por 7 días
                    promedioTextView.text = getString(R.string.promedio_semanal, averageWeeklyTime)
                } else {
                    bienvenidaTextView.text = "Nombre del Usuario"
                }
            }
        } ?: run {
            bienvenidaTextView.text = "Nombre del Usuario"
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
