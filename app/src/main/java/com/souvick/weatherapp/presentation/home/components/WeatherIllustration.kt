package com.souvick.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.souvick.weatherapp.domain.model.CurrentWeather

@Composable
fun WeatherIllustration(
    current: CurrentWeather?,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        AsyncImage(
            model = current?.iconUrl,
            contentDescription = null,
            modifier = Modifier.size(140.dp)
        )

    }

}