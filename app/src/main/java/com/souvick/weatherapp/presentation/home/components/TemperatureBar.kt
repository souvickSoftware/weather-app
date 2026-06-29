package com.souvick.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TemperatureBar(
    progress: Float
) {

    LinearProgressIndicator(
        progress = { progress },
        modifier = Modifier.width(80.dp)
    )

}