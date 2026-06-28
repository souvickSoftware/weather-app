package com.souvick.weatherapp.domain.model

data class HourlyWeather(

    val time: String,

    val temperature: Double,

    val condition: String,

    val iconUrl: String
)