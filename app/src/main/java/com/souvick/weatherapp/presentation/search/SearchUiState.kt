package com.souvick.weatherapp.presentation.search

import com.souvick.weatherapp.domain.model.City

data class SearchUiState(

    val query: String = "",

    val cities: List<City> = emptyList(),

    val isLoading: Boolean = false

)