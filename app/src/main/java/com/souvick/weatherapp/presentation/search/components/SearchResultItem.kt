package com.souvick.weatherapp.presentation.search.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.souvick.weatherapp.domain.model.City

@Composable
fun SearchResultItem(
    city: City,
    onClick: () -> Unit
) {

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null
            )

            Column {

                Text(
                    text = city.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "${city.region}, ${city.country}",
                    style = MaterialTheme.typography.bodyMedium
                )

            }

        }

    }

}