package com.souvick.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AirQualityChip() {

    Surface (
        modifier = Modifier.padding(start = 24.dp),
        shape = RoundedCornerShape(50),
        color = Color.White.copy(.20f)
    ) {

        Row(
            modifier = Modifier.padding(
                horizontal = 14.dp,
                vertical = 8.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text("🍃")

            Spacer(Modifier.width(8.dp))

            Text(
                "Good Air Quality",
                color = Color.White
            )

        }

    }

}