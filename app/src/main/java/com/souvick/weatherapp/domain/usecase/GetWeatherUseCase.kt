package com.souvick.weatherapp.domain.usecase

import com.souvick.weatherapp.domain.model.Weather
import com.souvick.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    operator fun invoke(city: String, forceRefresh: Boolean = false) =
        repository.getWeather(city, forceRefresh)

}