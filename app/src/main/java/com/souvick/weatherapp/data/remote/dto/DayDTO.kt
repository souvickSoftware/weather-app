package com.souvick.weatherapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DayDTO(

    @SerialName("maxtemp_c")
    val maxTemp: Double,

    @SerialName("mintemp_c")
    val minTemp: Double,

    @SerialName("condition")
    val condition: ConditionDTO
)