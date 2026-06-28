package com.souvick.weatherapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentDTO(

    @SerialName("temp_c")
    val temperature: Double,

    @SerialName("humidity")
    val humidity: Int,

    @SerialName("wind_kph")
    val windSpeed: Double,

    @SerialName("pressure_mb")
    val pressure: Double,

    @SerialName("uv")
    val uv: Double,

    @SerialName("feelslike_c")
    val feelsLike: Double,

    @SerialName("condition")
    val condition: ConditionDTO
)