package com.souvick.weatherapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.souvick.weatherapp.core.common.Resource
import com.souvick.weatherapp.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        observeWeather("Bengaluru")
    }

    private fun observeWeather(
        city: String
    ) {

        viewModelScope.launch {

            getWeatherUseCase(city)
                .collect { weather ->

                    _uiState.value = HomeUiState(
                        weather = weather
                    )

                }

        }

    }
}