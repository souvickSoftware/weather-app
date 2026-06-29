package com.souvick.weatherapp.presentation.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.souvick.weatherapp.domain.model.City
import com.souvick.weatherapp.presentation.search.components.SearchResultItem

@Composable
fun SearchScreen(
    onBack: () -> Unit,
    onCitySelected: (City) -> Unit,
    viewModel: SearchViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 20.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = onBack
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Search City",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = uiState.query,
            onValueChange = viewModel::onQueryChanged,
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            placeholder = {
                Text("Search for a city")
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        when {

            uiState.isLoading -> {

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }

            }

            uiState.query.isNotBlank() && uiState.cities.isEmpty() -> {

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No cities found")
                }

            }

            else -> {

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    items(uiState.cities) { city ->

                        SearchResultItem(
                            city = city,
                            onClick = {
                                onCitySelected(city)
                            }
                        )

                    }

                }

            }

        }

    }

}