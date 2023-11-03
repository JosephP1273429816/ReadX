package com.joseph.readxapp.data


data class TimeUser(
    var domingo: Long = 0,
    var lunes: Long = 0,
    var martes: Long = 0,
    var miércoles: Long = 0,
    var jueves: Long = 0,
    var viernes: Long = 0,
    var sábado: Long = 0,
    var lastResetTime: Long = 0,
    var averageWeeklyTime: Long = 0
)
