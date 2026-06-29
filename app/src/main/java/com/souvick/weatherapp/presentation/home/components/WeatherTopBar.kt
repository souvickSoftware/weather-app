package com.souvick.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherTopBar(
    city: String,
    country: String,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        IconButton(
            onClick = onSearchClick
        ) {

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White
            )

        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                "$city, $country",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )

            Spacer(Modifier.width(6.dp))

            Icon(
                Icons.Default.LocationOn,
                null,
                tint = Color.White,
                modifier = Modifier.size(18.dp)
            )

        }

        IconButton(
            onClick = {}
        ) {

            Icon(
                Icons.Default.MoreHoriz,
                null,
                tint = Color.White
            )

        }

    }

}