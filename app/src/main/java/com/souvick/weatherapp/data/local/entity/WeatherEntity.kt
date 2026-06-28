package com.souvick.weatherapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "weather")
data class WeatherEntity(

    @PrimaryKey
    val city: String,

    val country: String,

    val temperature: Double,

    val feelsLike: Double,

    val humidity: Int,

    val pressure: Double,

    val windSpeed: Double,

    val uvIndex: Double,

    val condition: String,

    val iconUrl: String,

    val lastUpdated: Long
)