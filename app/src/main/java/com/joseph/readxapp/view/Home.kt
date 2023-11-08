package com.joseph.readxapp.view

import android.os.Bundle
import android.util.Log
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
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
import com.joseph.readxapp.R

class HomeFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private val timeTracker: TimeTracker by lazy { TimeTracker.getInstance(requireContext()) }
    private var timeUser: TimeUser? = null
    private val TAG = "HomeFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.home, container, false)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val bienvenidaTextView = rootView.findViewById<TextView>(R.id.bienvenida)
        val promedioTextView = rootView.findViewById<TextView>(R.id.promedioTextView)
        val barChart = rootView.findViewById<BarChart>(R.id.barChart)

        // Agregar ProgressBar para la pantalla de carga
        val loadingProgressBar = rootView.findViewById<ProgressBar>(R.id.loadingProgressBar)
        val loadingLayout = rootView.findViewById<RelativeLayout>(R.id.loadingLayout)

        loadingProgressBar.visibility = View.VISIBLE
        loadingLayout.visibility = View.VISIBLE

        Handler().postDelayed(
            {
                loadingProgressBar.visibility = View.GONE
                loadingLayout.visibility = View.GONE
            },
            2000
        ) // Oculta el ProgressBar y el RelativeLayout después de 2000 milisegundos (2 segundos)

        // Configurar la visibilidad del ProgressBar
        loadingProgressBar.visibility = View.VISIBLE // Mostrar ProgressBar al cargar

        val listViewSemanal = rootView.findViewById<ListView>(R.id.SemanalrankingListView)
        val listView = rootView.findViewById<ListView>(R.id.rankingListView)
        val userScores = mutableMapOf<String?, Long?>()




        db.collection("scores")
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Log.w(TAG, "Escucha fallida.", e)
                    return@addSnapshotListener
                }

                userScores.clear()

                for (document in snapshots!!) {
                    val userName = document.getString("name")
                    val weeklyScore = document.getLong("weeklyScore")
                    userScores[userName] = weeklyScore
                }

                // Ordena el mapa por valores y toma solo los 10 primeros
                val top10UserScores =
                    userScores.toList().sortedByDescending { (_, value) -> value }.take(10)

                // Determinar la posición del usuario actual
                val currentUser = FirebaseAuth.getInstance().currentUser?.displayName
                val currentUserScore = userScores[currentUser]

                // Crear una lista para el ArrayAdapter de puntuaciones globales
                val displayList = top10UserScores.mapIndexed { index, pair ->
                    val userPosition = index + 1
                    "$userPosition. ${pair.first}: ${pair.second ?: "N/A"}"
                }.toMutableList()

                // Si el usuario no está en el top 10, agregarlo como el puesto 11
                if (currentUser != null && currentUserScore != null) {
                    val userPosition = displayList.indexOfFirst { it.startsWith(currentUser) }
                    if (userPosition == -1) {
                        displayList.add("11. $currentUser: $currentUserScore")
                    }
                }

                // Crear un ArrayAdapter personalizado para utilizar el diseño list_item.xml
                val adapter = ArrayAdapter(
                    requireContext(),
                    R.layout.list_item,
                    R.id.list_item_text,
                    displayList
                )

                // Asigna el ArrayAdapter al ListView de puntuaciones globales
                listViewSemanal.adapter = adapter
            }

        db.collection("scores")
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Log.w(TAG, "Escucha fallida.", e)
                    return@addSnapshotListener
                }

                userScores.clear()

                for (document in snapshots!!) {
                    val userName = document.getString("name")
                    val weeklyScore = document.getLong("globalScore")
                    userScores[userName] = weeklyScore
                }

                // Ordena el mapa por valores y toma solo los 10 primeros
                val top10UserScores =
                    userScores.toList().sortedByDescending { (_, value) -> value }.take(10)

                // Determinar la posición del usuario actual
                val currentUser = FirebaseAuth.getInstance().currentUser?.displayName
                val currentUserScore = userScores[currentUser]

                // Crear una lista para el ArrayAdapter de puntuaciones globales
                val displayList = top10UserScores.mapIndexed { index, pair ->
                    val userPosition = index + 1
                    "$userPosition. ${pair.first}: ${pair.second ?: "N/A"}"
                }.toMutableList()

                // Si el usuario no está en el top 10, agregarlo como el puesto 11
                if (currentUser != null && currentUserScore != null) {
                    val userPosition = displayList.indexOfFirst { it.startsWith(currentUser) }
                    if (userPosition == -1) {
                        displayList.add("11. $currentUser: $currentUserScore")
                    }
                }

                // Crear un ArrayAdapter personalizado para utilizar el diseño list_item.xml
                val adapter = ArrayAdapter(
                    requireContext(),
                    R.layout.list_item,
                    R.id.list_item_text,
                    displayList
                )

                // Asigna el ArrayAdapter al ListView de puntuaciones globales
                listView.adapter = adapter
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
                            bienvenidaTextView.text =
                                getString(R.string.bienvenido_name, nombreUsuario)
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
            val backgroundColor = ContextCompat.getColor(requireContext(), R.color.gris)
            barChart.setBackgroundColor(backgroundColor)
            barChart.description.isEnabled = false // Quita la descripción

            // Configura el eje X para mostrar los nombres de los días de la semana
            val xAxis = barChart.xAxis
            xAxis.position =
                XAxis.XAxisPosition.BOTTOM // Posiciona las etiquetas del eje X en la parte inferior de la gráfica
            xAxis.setDrawGridLines(false) // Quita las líneas de cuadrícula del eje X
            xAxis.textSize = 10f // Cambia el tamaño de la fuente de las etiquetas del eje X

            // Aquí es donde puedes cambiar la fuente a una personalizada
            val typeface = ResourcesCompat.getFont(requireContext(), R.font.fonttex)
            xAxis.typeface = typeface
            xAxis.textColor = ContextCompat.getColor(requireContext(), R.color.white)

            // Configura el eje Y para que comience en 0
            val yAxisLeft = barChart.axisLeft
            yAxisLeft.axisMinimum = 0f // Establece el valor mínimo del eje Y en 0
            yAxisLeft.textColor = ContextCompat.getColor(requireContext(), R.color.white)

            val yAxisRight = barChart.axisRight
            yAxisRight.axisMinimum = 0f // Establece el valor mínimo del eje Y en 0
            yAxisRight.textColor = ContextCompat.getColor(requireContext(), R.color.white)

            // Recupera los datos de Firestore para llenar la gráfica de barras
            db.collection("TimeUser").document(userId).get()
                .addOnSuccessListener { documentSnapshot ->
                    if (documentSnapshot.exists()) {
                        timeUser = documentSnapshot.toObject(TimeUser::class.java)

                        val entries = ArrayList<BarEntry>()
                        val daysOfWeek = listOf(
                            "domingo",
                            "lunes",
                            "martes",
                            "miércoles",
                            "jueves",
                            "viernes",
                            "sábado"
                        )

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

                        xAxis.valueFormatter = IndexAxisValueFormatter(
                            listOf(
                                "Domingo",
                                "Lunes",
                                "Martes",
                                "Miércoles",
                                "Jueves",
                                "Viernes",
                                "Sábado"
                            )
                        ) // Establece las etiquetas del eje X como los días de la semana

                        val dataSet = BarDataSet(entries, "")
                        dataSet.valueTextColor =
                            ContextCompat.getColor(requireContext(), R.color.white)
                        dataSet.valueTextSize = 10f
                        dataSet.setDrawValues(true)

                        // Aquí es donde puedes cambiar el color a uno personalizado
                        dataSet.color = ContextCompat.getColor(requireContext(), R.color.white)

                        // Configura el tamaño de la fuente de los valores en las barras
                        dataSet.valueTextSize = 10f
                        dataSet.setDrawValues(true)

                        val data =
                            BarData(dataSet) // Crea los datos para la gráfica a partir del conjunto de datos

                        barChart.data = data // Establece los datos de la gráfica
                        barChart.invalidate() // Redibuja la gráfica con los nuevos datos

                        // Calcular el promedio semanal dividiendo siempre por 7 días
                        val totalWeeklyTime = (timeUser?.lunes ?: 0) +
                                (timeUser?.martes ?: 0) + (timeUser?.miércoles ?: 0) +
                                (timeUser?.jueves ?: 0) + (timeUser?.viernes ?: 0) +
                                (timeUser?.sábado ?: 0) + (timeUser?.domingo ?: 0)

                        val averageWeeklyTime = totalWeeklyTime / 7 // Dividir por 7 días
                        promedioTextView.text =
                            getString(R.string.promedio_semanal, averageWeeklyTime)
                    } else {
                        bienvenidaTextView.text = "Nombre del Usuario"
                    }
                }
        } ?: run {
            bienvenidaTextView.text = "Nombre del Usuario"
        }

        return rootView
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

