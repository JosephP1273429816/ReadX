package com.joseph.readxapp.data

import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import java.util.concurrent.TimeUnit
import android.net.ConnectivityManager

class TimeTracker private constructor(private val context: Context) {
    private val db = FirebaseFirestore.getInstance()
    private val userId = FirebaseAuth.getInstance().currentUser?.uid
    private var startTimeMillis: Long = 0
    private val sharedPrefs: SharedPreferences
    private val lastResetWeekKey = "lastResetWeek"
    private var disconnectedTimeMillis: Long = 0 // Nuevo

    companion object {
        @Volatile
        private var INSTANCE: TimeTracker? = null

        fun getInstance(context: Context): TimeTracker {
            return INSTANCE ?: synchronized(this) {
                val instance = TimeTracker(context)
                INSTANCE = instance
                instance
            }
        }
    }

    init {
        sharedPrefs = context.getSharedPreferences("TimeTrackerPrefs", Context.MODE_PRIVATE)
        val lastResetWeek = sharedPrefs.getInt(lastResetWeekKey, -1)
        val currentWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR)

        // Si la última semana de reinicio no es la semana actual, reinicia el tiempo
        if (lastResetWeek != currentWeek) {
            resetTime()
        }
    }

    fun startTrackingTime() {
        // Solo registra el tiempo de inicio si no se ha registrado previamente
        if (startTimeMillis == 0L) {
            startTimeMillis = System.currentTimeMillis()
        }
    }

    fun stopTrackingTime() {
        val dayOfWeek = getDayOfWeek()
        val endTimeMillis = System.currentTimeMillis()
        val elapsedTimeMillis = endTimeMillis - startTimeMillis

        // Guarda el tiempo localmente si no hay conexión a Internet
        if (!isConnectedToInternet()) {
            disconnectedTimeMillis += elapsedTimeMillis
            val previousTimeMillis = sharedPrefs.getLong(dayOfWeek, 0)
            val newTimeMillis = previousTimeMillis + elapsedTimeMillis
            val editor = sharedPrefs.edit()
            editor.putLong(dayOfWeek, newTimeMillis)
            editor.apply()
        } else {
            // Suma el tiempo guardado localmente al tiempo en Firestore
            if (disconnectedTimeMillis > 0) {
                val previousTimeMillis = sharedPrefs.getLong(dayOfWeek, 0)
                val newTimeMillis = previousTimeMillis + disconnectedTimeMillis
                val editor = sharedPrefs.edit()
                editor.putLong(dayOfWeek, newTimeMillis)
                editor.apply()
                disconnectedTimeMillis = 0
                // Sincroniza el tiempo con Firestore
                syncTimeWithFirestore(dayOfWeek, newTimeMillis)
            } else {
                // Sincroniza el tiempo con Firestore si no hay tiempo local guardado
                syncTimeWithFirestore(dayOfWeek, elapsedTimeMillis)
            }
        }
    }

    private fun syncTimeWithFirestore(dayOfWeek: String, elapsedTimeMillis: Long) {
        val userRef = db.collection("TimeUser").document(userId!!)
        userRef.get().addOnSuccessListener { documentSnapshot ->
            val previousTimeMillis = documentSnapshot.getLong(dayOfWeek) ?: 0
            val newTimeMillis = previousTimeMillis + elapsedTimeMillis

            // Redondea el valor al minuto más cercano
            val roundedTimeMillis = convertMillisToTimeFormat(newTimeMillis)

            // Actualiza el valor redondeado en Firestore
            val data = hashMapOf<String, Any>(
                dayOfWeek to roundedTimeMillis
            )
            userRef.update(data)
        }
    }

    private fun isConnectedToInternet(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnected == true
    }

    fun resetWeeklyTime() {
        val currentWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR)
        // Guarda la semana actual como la última semana de reinicio en SharedPreferences
        val editor = sharedPrefs.edit()
        editor.putInt(lastResetWeekKey, currentWeek)
        editor.apply()
    }

    private fun resetTime() {
        // Puedes realizar las operaciones necesarias para reiniciar el tiempo
        // Esto puede incluir la reinicialización de las preferencias compartidas, por ejemplo.
        val editor = sharedPrefs.edit()
        editor.clear() // Esto eliminará todos los tiempos guardados localmente
        editor.apply()
    }

    private fun getDayOfWeek(): String {
        val calendar = Calendar.getInstance()
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        val daysOfWeek = listOf("domingo", "lunes", "martes", "miércoles", "jueves", "viernes", "sábado")

        return daysOfWeek[dayOfWeek - 1]  // Mantener en minúsculas, sin el .capitalize()
    }

    private fun convertMillisToTimeFormat(millis: Long): Long {
        val totalSeconds = TimeUnit.MILLISECONDS.toSeconds(millis)
        val minutes = TimeUnit.SECONDS.toMinutes(totalSeconds)

        return minutes
    }
}

