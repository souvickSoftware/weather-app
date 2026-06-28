package com.souvick.weatherapp.presentation.home

import com.souvick.weatherapp.domain.model.CurrentWeather
import com.souvick.weatherapp.domain.model.Weather

data class HomeUiState(

    val isLoading: Boolean = false,

    val weather: CurrentWeather? = null,

    val error: String? = null
)