package com.souvick.weatherapp.data.repository

import com.souvick.weatherapp.core.common.Resource
import com.souvick.weatherapp.data.remote.api.WeatherApi
import com.souvick.weatherapp.domain.model.Weather
import com.souvick.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeather(
        city: String
    ): Resource<Weather> {

        TODO("Map API response to domain model")

    }
}