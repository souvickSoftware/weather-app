package com.souvick.weatherapp.domain.repository

import com.souvick.weatherapp.core.common.Resource
import com.souvick.weatherapp.domain.model.CurrentWeather
import com.souvick.weatherapp.domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    fun getWeather(
        city: String,
        forceRefresh: Boolean = false
    ): Flow<Weather>

}