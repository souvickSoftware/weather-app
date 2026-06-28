package com.souvick.weatherapp.data.mapper

import com.souvick.weatherapp.data.local.entity.DailyForecastEntity
import com.souvick.weatherapp.data.local.entity.HourlyForecastEntity
import com.souvick.weatherapp.data.local.entity.WeatherEntity
import com.souvick.weatherapp.data.remote.dto.ForecastResponseDTO


fun ForecastResponseDTO.toWeatherEntity(): WeatherEntity {

    return WeatherEntity(
        city = location.name,
        country = location.country,
        temperature = current.temperature,
        feelsLike = current.feelsLike,
        humidity = current.humidity,
        pressure = current.pressure,
        windSpeed = current.windSpeed,
        uvIndex = current.uv,
        condition = current.condition.text,
        iconUrl = "https:${current.condition.icon}",
        lastUpdated = System.currentTimeMillis()
    )
}

fun ForecastResponseDTO.toHourlyEntities(): List<HourlyForecastEntity> {

    return forecast.forecastDays
        .flatMap { forecastDay ->

            forecastDay.hours.map { hour ->

                HourlyForecastEntity(
                    city = location.name,
                    time = hour.time,
                    temperature = hour.temperature,
                    condition = hour.condition.text,
                    iconUrl = "https:${hour.condition.icon}"
                )

            }

        }

}

fun ForecastResponseDTO.toDailyEntities(): List<DailyForecastEntity> {

    return forecast.forecastDays.map { day ->

        DailyForecastEntity(
            city = location.name,
            date = day.date,
            maxTemperature = day.day.maxTemp,
            minTemperature = day.day.minTemp,
            condition = day.day.condition.text,
            iconUrl = "https:${day.day.condition.icon}"
        )

    }

}