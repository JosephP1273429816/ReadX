package com.joseph.readxapp.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query


class RankingHandler {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun getRanking(callback: (List<User>) -> Unit) {
        val usersRef = db.collection("users")

        usersRef
            .orderBy("scores.globalScore", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { querySnapshot ->
                val userList = mutableListOf<User>()

                for (document in querySnapshot.documents) {
                    val user = document.toObject(User::class.java)
                    user?.let { userList.add(it) }
                }

                callback(userList)
            }
            .addOnFailureListener { exception ->
                // Manejar errores aquí
            }
    }
}
