package com.souvick.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.souvick.weatherapp.domain.model.CurrentWeather

@Composable
fun CurrentWeatherSection(
    current: CurrentWeather?,
    modifier: Modifier = Modifier
) {


    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                "${current?.temperature?.toInt() ?: "--"}°",
                fontSize = 84.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                current?.condition.orEmpty(),
                fontSize = 28.sp,
                color = Color.White
            )

            Text(
                "Feels like ${current?.feelsLike?.toInt() ?: "--"}°",
                fontSize = 18.sp,
                color = Color.White.copy(alpha = 0.8f)
            )
        }

        WeatherIllustration(
            current = current,
            modifier = Modifier
                .size(170.dp)
                .padding(start = 16.dp)
        )
    }

}