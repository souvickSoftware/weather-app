package com.souvick.weatherapp.data.mapper

import com.souvick.weatherapp.data.remote.dto.ForecastResponseDTO
import com.souvick.weatherapp.domain.model.Weather

fun ForecastResponseDTO.toDomain(): Weather {
    return Weather(
        city = location.name,
        country = location.country,
        temperature = current.temperature,
        feelsLike = current.feelsLike,
        humidity = current.humidity,
        pressure = current.pressure,
        windSpeed = current.windSpeed,
        uvIndex = current.uv,
        condition = current.condition.text,
        iconUrl = "https:${current.condition.icon}"
    )
}