package com.souvick.weatherapp.domain.model

data class DailyWeather(

    val date: String,

    val maxTemperature: Double,

    val minTemperature: Double,

    val condition: String,

    val iconUrl: String
)