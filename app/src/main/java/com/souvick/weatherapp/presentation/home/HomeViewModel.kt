package com.souvick.weatherapp.presentation.home

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.souvick.weatherapp.core.common.Resource
import com.souvick.weatherapp.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.core.content.edit

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    companion object {
        private const val KEY_SELECTED_CITY = "selected_city"
        private const val DEFAULT_CITY = "Bengaluru"
    }

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()
    private var currentCity: String? = null

    private var job: Job? = null

    init {
        loadWeather(
            sharedPreferences.getString(
                KEY_SELECTED_CITY,
                DEFAULT_CITY
            )!!
        )
//        observeWeather(currentCity)
    }

    private fun fetchWeather(
        city: String,
        forceRefresh: Boolean
    ) {
        job?.cancel()

        job = viewModelScope.launch {
            getWeatherUseCase(
                city = city,
                forceRefresh = forceRefresh
            ).collect { weather ->
                _uiState.update {
                    it.copy(weather = weather)
                }
            }
        }
    }

    fun loadWeather(city: String) {

        if (city == currentCity) return

        currentCity = city

        sharedPreferences.edit {
            putString(KEY_SELECTED_CITY, city)
        }

        fetchWeather(city, false)
    }

    fun refreshWeather() {
        currentCity?.let {
            fetchWeather(it, true)
        }
    }

}