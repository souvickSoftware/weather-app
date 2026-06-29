package com.souvick.weatherapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.souvick.weatherapp.presentation.home.components.AirQualityChip
import com.souvick.weatherapp.presentation.home.components.CurrentWeatherSection
import com.souvick.weatherapp.presentation.home.components.HourlyForecastSection
import com.souvick.weatherapp.presentation.home.components.LoadingHomeScreen
import com.souvick.weatherapp.presentation.home.components.WeatherIllustration
import com.souvick.weatherapp.presentation.home.components.WeatherTopBar
import com.souvick.weatherapp.presentation.home.components.WeeklyForecastSection

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (uiState.isLoading) {
        LoadingHomeScreen()
        return
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF4A90E2),
                        Color(0xFF7FD6FF),
                        Color(0xFFEAF7FF)
                    )
                )
            )
    ) {

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(scrollState)
        ) {

            Spacer(modifier = Modifier.height(48.dp))

            WeatherTopBar(
                city = uiState.weather?.current?.city ?: "Bengaluru",
                country = uiState.weather?.current?.country ?: "India",
                onSearchClick
            )

            Spacer(modifier = Modifier.height(20.dp))

            CurrentWeatherSection(
                current = uiState.weather?.current
            )

            Spacer(modifier = Modifier.height(24.dp))

            AirQualityChip()

            Spacer(modifier = Modifier.height(24.dp))

//            WeatherIllustration(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(180.dp)
//            )
//
//            Spacer(modifier = Modifier.height(24.dp))

            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp
                ),
                color = Color.White
            ) {

                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    HourlyForecastSection(
                        hourly = uiState.weather?.hourly.orEmpty()
                    )

                    WeeklyForecastSection(
                        daily = uiState.weather?.daily.orEmpty()
                    )

                    Spacer(modifier = Modifier.height(32.dp))
                }

            }

        }

    }
}