package com.souvick.weatherapp.domain.model

data class CurrentWeather(
    val city: String,
    val country: String,
    val temperature: Double,
    val feelsLike: Double,
    val humidity: Int,
    val pressure: Double,
    val windSpeed: Double,
    val uvIndex: Double,
    val condition: String,
    val iconUrl: String
)