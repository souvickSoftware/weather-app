package com.souvick.weatherapp.domain.usecase

import com.souvick.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(
        city: String
    ) = repository.getWeather(city)

}