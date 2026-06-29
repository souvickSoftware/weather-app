package com.souvick.weatherapp.util

//import com.souvick.weatherapp.data.local.entity.CurrentWeather
import com.souvick.weatherapp.data.local.entity.DailyForecastEntity
import com.souvick.weatherapp.data.local.entity.HourlyForecastEntity
import com.souvick.weatherapp.data.local.entity.WeatherEntity
import com.souvick.weatherapp.data.mapper.toCurrentWeather
import com.souvick.weatherapp.data.remote.dto.ConditionDTO
import com.souvick.weatherapp.data.remote.dto.CurrentDTO
import com.souvick.weatherapp.data.remote.dto.ForecastDayDTO
import com.souvick.weatherapp.data.remote.dto.ForecastDTO
import com.souvick.weatherapp.data.remote.dto.ForecastResponseDTO
import com.souvick.weatherapp.data.remote.dto.DayDTO
import com.souvick.weatherapp.domain.model.CurrentWeather
import com.souvick.weatherapp.domain.model.Weather

object FakeData {

    const val CITY = "London"

    fun weather() = Weather(
        current = currentEntity().toCurrentWeather(),
        hourly = emptyList(),
        daily = emptyList(),
        lastUpdated = System.currentTimeMillis()
    )

    fun currentEntity() = WeatherEntity(
        cityKey = CITY,
        city = CITY,
        country = "United Kingdom",
        temperature = 24.5,
        condition = "Sunny",
        iconUrl = "//cdn.weatherapi.com/weather/64x64/day/113.png",
        humidity = 60,
        pressure = 29.0,
        windSpeed = 12.0,
        uvIndex = 5.0,
        feelsLike = 25.0,
        lastUpdated = System.currentTimeMillis()
    )

    fun hourlyEntities() = emptyList<HourlyForecastEntity>()

    fun dailyEntities() = emptyList<DailyForecastEntity>()
}