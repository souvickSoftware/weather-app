package com.souvick.weatherapp.presentation.home

import com.souvick.weatherapp.domain.model.Weather

data class HomeUiState(

    val isLoading: Boolean = false,

    val weather: Weather? = null,

    val error: String? = null
)