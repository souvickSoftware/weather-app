package com.souvick.weatherapp.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.souvick.weatherapp.core.extensions.toUserMessage
import com.souvick.weatherapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState = _uiState.asStateFlow()

    init {

        viewModelScope.launch {

            uiState
                .map { it.query }
                .debounce(400)
                .distinctUntilChanged()
                .filter { it.length >= 2 }
                .collect {

                    search(it)

                }

        }

    }

    fun onQueryChanged(query: String) {

        _uiState.update {
            it.copy(query = query)
        }

    }
    private suspend fun search(query: String) {

        _uiState.update {
            it.copy(
                isLoading = true,
                errorMessage = null
            )
        }

        try {

            val cities = repository.searchCities(query)

            _uiState.update {
                it.copy(
                    isLoading = false,
                    cities = cities
                )
            }

        } catch (e: Exception) {

            _uiState.update {
                it.copy(
                    isLoading = false,
                    errorMessage = e.toUserMessage()
                )
            }

        }
    }
}