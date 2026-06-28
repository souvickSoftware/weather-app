package com.souvick.weatherapp.data.repository

import com.souvick.weatherapp.core.common.Resource
import com.souvick.weatherapp.data.mapper.toDomain
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

        return try {

            val response = api.getForecast(city)
            Resource.Success(response.toDomain())

        } catch (e: Exception) {
            Resource.Error( e.message ?: "Something went wrong", e)
        }
    }
}