package com.souvick.weatherapp.domain.repository

import com.souvick.weatherapp.core.common.Resource
import com.souvick.weatherapp.domain.model.CurrentWeather

interface WeatherRepository {

    suspend fun getWeather(
        city: String
    ): Resource<CurrentWeather>

}