package com.joseph.readxapp.data

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.joseph.readxapp.R

data class UserRankingItem(val rank: Int, val name: String, val score: Int)

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)  // Asegúrate de que coincida con el nombre de tu archivo XML

        // Supongamos que tienes dos listas de objetos UserRankingItem, una para el ranking semanal y otra para el ranking global
        val weeklyRankingData = listOf(
            UserRankingItem(1, "Usuario1", 1000),
            UserRankingItem(2, "Usuario2", 900),
            UserRankingItem(3, "Usuario3", 800),
            // ... Otros usuarios
        )

        val globalRankingData = listOf(
            UserRankingItem(1, "UsuarioA", 2000),
            UserRankingItem(2, "UsuarioB", 1800),
            UserRankingItem(3, "UsuarioC", 1600),
            // ... Otros usuarios
        )

        val textViewWeeklyRanking = findViewById<TextView>(R.id.textViewSemanalRanking)
        val textViewGlobalRanking = findViewById<TextView>(R.id.textViewGlobalRanking)

        // Construye una cadena con el ranking semanal y muestra los 11 primeros elementos en el primer TextView
        val weeklyRankingText = buildRankingText(weeklyRankingData)
        textViewWeeklyRanking.text = weeklyRankingText

        // Construye una cadena con el ranking global y muestra los 11 primeros elementos en el segundo TextView
        val globalRankingText = buildRankingText(globalRankingData)
        textViewGlobalRanking.text = globalRankingText
    }

    private fun buildRankingText(rankingData: List<UserRankingItem>): String {
        return buildString {
            for (i in 0 until 11) {
                if (i < rankingData.size) {
                    val user = rankingData[i]
                    append("${user.rank}. ${user.name} - ${user.score} puntos")
                    if (i < 10) {
                        append("\n")  // Agrega un salto de línea después de cada usuario, excepto el último
                    }
                } else {
                    append("${i + 1}. Puesto ${i + 1}")
                    if (i < 10) {
                        append("\n")  // Agrega un salto de línea después de cada puesto, excepto el último
                    }
                }
            }
        }
    }
}
