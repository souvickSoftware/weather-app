package com.souvick.weatherapp.presentation.home.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign

@Composable
fun LastUpdatedSection(
    lastUpdated: Long,
    modifier: Modifier = Modifier
) {

    var currentTime by remember {
        mutableLongStateOf(System.currentTimeMillis())
    }

    LaunchedEffect(lastUpdated) {
        while (true) {
            delay(60000)
            currentTime = System.currentTimeMillis()
        }
    }

    Text(
        text = formatLastUpdated(lastUpdated, currentTime),
        modifier = modifier,
        style = MaterialTheme.typography.bodySmall,
        color = Color.White.copy(alpha = 0.7f),
        textAlign = TextAlign.Center
    )
}

private fun formatLastUpdated(
    lastUpdated: Long,
    now: Long
): String {

    val minutes = ((now - lastUpdated) / 60000).coerceAtLeast(0)

    return when {
        minutes == 0L -> "Updated just now"
        minutes == 1L -> "Updated 1 minute ago"
        minutes < 60 -> "Updated $minutes minutes ago"
        else -> {
            val hours = minutes / 60
            "Updated $hours hour${if (hours > 1) "s" else ""} ago"
        }
    }
}