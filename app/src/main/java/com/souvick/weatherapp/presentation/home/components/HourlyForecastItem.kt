package com.souvick.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.souvick.weatherapp.domain.model.HourlyWeather

@Composable
fun HourlyForecastItem(
    weather: HourlyWeather,
    selected: Boolean = false
) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor =
                if (selected)
                    Color(0xFFEAF2FF)
                else
                    Color.Transparent
        ),
        shape = RoundedCornerShape(20.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(weather.time)

            Spacer(Modifier.height(12.dp))

            AsyncImage(
                model = weather.iconUrl,
                contentDescription = null,
                modifier = Modifier.size(42.dp)
            )

            Spacer(Modifier.height(12.dp))

            Text("${weather.temperature.toInt()}°")

        }

    }

}