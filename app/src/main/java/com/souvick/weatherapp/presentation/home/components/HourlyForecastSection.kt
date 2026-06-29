package com.souvick.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.souvick.weatherapp.domain.model.HourlyWeather

@Composable
fun HourlyForecastSection(
    hourly: List<HourlyWeather>
) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        itemsIndexed(hourly) { index, item ->

            HourlyForecastItem(
                weather = item,
                selected = index == 0
            )

        }

    }

}