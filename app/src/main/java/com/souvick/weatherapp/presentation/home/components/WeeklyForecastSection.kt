package com.souvick.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.souvick.weatherapp.domain.model.DailyWeather

@Composable
fun WeeklyForecastSection(
    daily: List<DailyWeather>
) {

    Column {

        Spacer(Modifier.height(4.dp))

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                "7-Day Forecast",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )

        }

        Spacer(Modifier.height(20.dp))

        daily.forEach {

            WeeklyForecastItem(it)

            HorizontalDivider()

        }

    }

}