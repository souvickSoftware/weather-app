package com.souvick.weatherapp.domain.model

data class City(
    val id: Int,
    val name: String,
    val region: String,
    val country: String,
    val latitude: Double,
    val longitude: Double
)