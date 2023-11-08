package com.joseph.readxapp.data

import com.google.firebase.firestore.FirebaseFirestore

class ScoreManager {
    private val db = FirebaseFirestore.getInstance()

    fun saveWeeklyScore(userId: String, newWeeklyScore: Int) {
        val scoresRef = db.collection("scores").document(userId)

        // Obten el puntaje semanal actual
        scoresRef.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot.exists()) {
                val currentWeeklyScore = documentSnapshot.getLong("weeklyScore") ?: 0
                val updatedWeeklyScore = currentWeeklyScore + newWeeklyScore
                scoresRef.update("weeklyScore", updatedWeeklyScore)
            }
        }
    }

    fun saveGlobalScore(userId: String, newGlobalScore: Int) {
        val scoresRef = db.collection("scores").document(userId)

        // Obten el puntaje global actual
        scoresRef.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot.exists()) {
                val currentGlobalScore = documentSnapshot.getLong("globalScore") ?: 0
                val updatedGlobalScore = currentGlobalScore + newGlobalScore
                scoresRef.update("globalScore", updatedGlobalScore)
            }
        }
    }

    fun resetWeeklyScore(userId: String) {
        val scoresRef = db.collection("scores").document(userId)
        scoresRef.update("weeklyScore", 0)
    }

    fun getScoresForUser(userId: String) {
        val scoresRef = db.collection("scores").document(userId)
        scoresRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    // Aquí puedes recuperar los puntajes del documento y mostrarlos en tu aplicación.
                    val weeklyScore = document.getLong("weeklyScore")
                    val globalScore = document.getLong("globalScore")
                } else {
                    // El documento no existe.
                }
            }
            .addOnFailureListener { exception ->
                // Handle errors here.
            }
    }
}

