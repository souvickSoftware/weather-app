package com.souvick.weatherapp.core.extensions

import com.souvick.weatherapp.domain.model.HourlyWeather
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun List<HourlyWeather>.next24Hours(): List<HourlyWeather> {

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    val now = LocalDateTime.now()

    return filter {
        val time = LocalDateTime.parse(it.time, formatter)

        !time.isBefore(now.minusHours(1))
    }.take(24)
}