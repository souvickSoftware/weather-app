package com.souvick.weatherapp.presentation.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.souvick.weatherapp.presentation.home.HomeScreen
import com.souvick.weatherapp.presentation.home.HomeViewModel
import com.souvick.weatherapp.presentation.search.SearchScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {

            val homeViewModel: HomeViewModel = hiltViewModel()

            val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

            val selectedCity by navController.currentBackStackEntry!!
                .savedStateHandle
                .getStateFlow<String?>(
                    "selected_city",
                    null
                )
                .collectAsStateWithLifecycle()

            LaunchedEffect(selectedCity) {

                selectedCity?.let { city ->

                    homeViewModel.loadWeather(city)

                    navController.currentBackStackEntry
                        ?.savedStateHandle
                        ?.remove<String>("selected_city")
                }

            }

            HomeScreen(
                uiState = uiState,
                onSearchClick = {
                    navController.navigate(Screen.Search.route)
                }
            )

        }

        composable(Screen.Search.route) {

            SearchScreen(

                onBack = {
                    navController.popBackStack()
                },

                onCitySelected = { city ->

                    navController.previousBackStackEntry
                        ?.savedStateHandle
                        ?.set("selected_city", city.name)

                    navController.popBackStack()

                }

            )

        }

    }

}