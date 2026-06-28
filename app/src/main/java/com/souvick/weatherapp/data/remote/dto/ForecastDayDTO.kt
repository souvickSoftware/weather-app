package com.souvick.weatherapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastDayDTO(

    @SerialName("date")
    val date: String,

    @SerialName("day")
    val day: DayDTO,

    @SerialName("hour")
    val hours: List<HourDTO>
)