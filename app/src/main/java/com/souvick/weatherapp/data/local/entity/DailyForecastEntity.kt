package com.souvick.weatherapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_forecast")
data class DailyForecastEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val city: String,

    val date: String,

    val maxTemperature: Double,

    val minTemperature: Double,

    val condition: String,

    val iconUrl: String
)