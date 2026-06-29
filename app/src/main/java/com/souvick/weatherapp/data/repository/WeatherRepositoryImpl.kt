package com.souvick.weatherapp.data.repository

import com.souvick.weatherapp.core.common.CacheConstants
import com.souvick.weatherapp.data.local.dao.WeatherDao
import com.souvick.weatherapp.data.mapper.toCity
import com.souvick.weatherapp.data.mapper.toDailyEntities
import com.souvick.weatherapp.data.mapper.toHourlyEntities
import com.souvick.weatherapp.data.mapper.toWeather
import com.souvick.weatherapp.data.mapper.toWeatherEntity
import com.souvick.weatherapp.data.remote.api.WeatherApi
import com.souvick.weatherapp.domain.model.City
import com.souvick.weatherapp.domain.model.Weather
import com.souvick.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
    private val dao: WeatherDao
) : WeatherRepository {

    override fun getWeather(
        city: String,
        forceRefresh: Boolean
    ): Flow<Weather> = flow {
        try {
            refreshIfNeeded(city, forceRefresh)
        } catch (e: Exception) {

            // Ignore network failures if we already have cached data.
            // The Flow from Room below will still emit cached values.
        }

        emitAll(
            combine(
                dao.observeCurrentWeather(city),
                dao.observeHourlyForecast(city),
                dao.observeDailyForecast(city)
            ) { current, hourly, daily ->
                requireNotNull(current)
                    .toWeather(hourly, daily)
            }
        )
    }

    private suspend fun refreshIfNeeded(
        city: String,
        forceRefresh: Boolean
    ) {

        val cached = dao.getCurrentWeather(city)

        val shouldRefresh = forceRefresh || cached == null ||
                    System.currentTimeMillis() - cached.lastUpdated >
                    CacheConstants.WEATHER_TTL

        if (!shouldRefresh) return

        val response = api.getForecast(city)

        dao.insertCurrentWeather(
            response.toWeatherEntity()
        )

        dao.deleteHourlyForecast(city)

        dao.insertHourlyForecast(
            response.toHourlyEntities()
        )

        dao.deleteDailyForecast(city)

        dao.insertDailyForecast(
            response.toDailyEntities()
        )

    }

    override suspend fun searchCities(
        query: String
    ): List<City> {

        return api.searchCities(query)
            .map { it.toCity() }

    }

}