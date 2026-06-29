package com.souvick.weatherapp.data.mapper

import com.souvick.weatherapp.data.local.entity.DailyForecastEntity
import com.souvick.weatherapp.data.local.entity.HourlyForecastEntity
import com.souvick.weatherapp.data.local.entity.WeatherEntity
import com.souvick.weatherapp.domain.model.CurrentWeather
import com.souvick.weatherapp.domain.model.DailyWeather
import com.souvick.weatherapp.domain.model.HourlyWeather
import com.souvick.weatherapp.domain.model.Weather


fun WeatherEntity.toCurrentWeather() =
    CurrentWeather(
        city = city,
        country = country,
        temperature = temperature,
        feelsLike = feelsLike,
        humidity = humidity,
        pressure = pressure,
        windSpeed = windSpeed,
        uvIndex = uvIndex,
        condition = condition,
        iconUrl = iconUrl
    )

fun List<HourlyForecastEntity>.toHourlyWeather() =
    map {

        HourlyWeather(
            time = it.time,
            temperature = it.temperature,
            condition = it.condition,
            iconUrl = it.iconUrl
        )

    }

fun List<DailyForecastEntity>.toDailyWeather() =
    map {

        DailyWeather(
            date = it.date,
            maxTemperature = it.maxTemperature,
            minTemperature = it.minTemperature,
            condition = it.condition,
            iconUrl = it.iconUrl
        )

    }


fun WeatherEntity.toWeather(
    hourly: List<HourlyForecastEntity>,
    daily: List<DailyForecastEntity>,
    lastUpdated: Long
): Weather {

    return Weather(
        current = toCurrentWeather(),
        hourly = hourly.toHourlyWeather(),
        daily = daily.toDailyWeather(),
        lastUpdated = lastUpdated
    )

}