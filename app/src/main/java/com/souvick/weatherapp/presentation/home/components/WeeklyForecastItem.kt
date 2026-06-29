package com.souvick.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.souvick.weatherapp.domain.model.DailyWeather

@Composable
fun WeeklyForecastItem(
    weather: DailyWeather
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            weather.date,
            modifier = Modifier.weight(1f)
        )

        AsyncImage(
            model = weather.iconUrl,
            contentDescription = null,
            modifier = Modifier.size(34.dp)
        )

        Spacer(Modifier.width(12.dp))

        Text(
            weather.condition,
            modifier = Modifier.weight(1f)
        )

        Text("${weather.minTemperature.toInt()}°")

        Spacer(Modifier.width(10.dp))

        TemperatureBar(.7f)

        Spacer(Modifier.width(10.dp))

        Text("${weather.maxTemperature.toInt()}°")

    }

}