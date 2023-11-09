package com.joseph.readxapp.data

import com.google.firebase.firestore.FirebaseFirestore

class ScoreManager {
    private val db = FirebaseFirestore.getInstance()

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

    fun getScoresForUser(userId: String) {
        val scoresRef = db.collection("scores").document(userId)
        scoresRef.addSnapshotListener { documentSnapshot, e ->
            if (e != null) {
                // Handle errors here.
                return@addSnapshotListener
            }

            if (documentSnapshot != null && documentSnapshot.exists()) {
                // Aquí puedes recuperar los puntajes del documento y mostrarlos en tu aplicación.
                val globalScore = documentSnapshot.getLong("globalScore")
            } else {
                // El documento no existe.
            }
        }
    }
}
