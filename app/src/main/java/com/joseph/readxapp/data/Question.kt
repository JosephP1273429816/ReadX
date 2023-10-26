package com.joseph.readxapp.data

data class Question(
    val question: String,
    val text: String,
    val answers: List<String>,
    val correctAnswer: Int
)
