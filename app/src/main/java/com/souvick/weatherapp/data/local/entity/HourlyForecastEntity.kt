package com.souvick.weatherapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hourly_forecast")
data class HourlyForecastEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val city: String,

    val time: String,

    val temperature: Double,

    val condition: String,

    val iconUrl: String
)