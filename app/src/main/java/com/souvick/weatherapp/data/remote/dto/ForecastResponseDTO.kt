package com.souvick.weatherapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastResponseDTO(

    @SerialName("location")
    val location: LocationDTO,

    @SerialName("current")
    val current: CurrentDTO,

    @SerialName("forecast")
    val forecast: ForecastDTO
)