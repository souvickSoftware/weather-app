package com.souvick.weatherapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class  ForecastDTO (
    @SerialName("forecastday")
    val forecastDays: List<ForecastDayDTO>
)