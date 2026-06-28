package com.souvick.weatherapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationDTO(

    @SerialName("name")
    val name: String,

    @SerialName("country")
    val country: String,

    @SerialName("localtime")
    val localTime: String
)