package com.souvick.weatherapp.presentation.home

import android.content.SharedPreferences
import com.souvick.weatherapp.domain.model.Weather
import com.souvick.weatherapp.domain.usecase.GetWeatherUseCase
import com.souvick.weatherapp.util.MainDispatcherRule
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: HomeViewModel

    private val getWeatherUseCase = mockk<GetWeatherUseCase>()

    private val sharedPreferences = mockk<SharedPreferences>()

    private val editor = mockk<SharedPreferences.Editor>()

    @Before
    fun setup() {

        every {
            sharedPreferences.getString(any(), any())
        } returns "Bengaluru"

        every {
            sharedPreferences.edit()
        } returns editor

        every {
            editor.putString(any(), any())
        } returns editor

        every {
            editor.apply()
        } just runs
    }

    @Test
    fun `loads weather on init`() = runTest {

        val weather = mockk<Weather>()

        every {
            getWeatherUseCase(
                "Bengaluru",
                false
            )
        } returns flowOf(weather)

        viewModel = HomeViewModel(
            getWeatherUseCase,
            sharedPreferences
        )

        advanceUntilIdle()

        assertEquals(
            weather,
            viewModel.uiState.value.weather
        )
    }

    @Test
    fun `loading another city updates ui`() = runTest {

        val bengaluruWeather = mockk<Weather>()
        val londonWeather = mockk<Weather>()

        every {
            getWeatherUseCase(
                "Bengaluru",
                false
            )
        } returns flowOf(bengaluruWeather)

        every {
            getWeatherUseCase(
                "London",
                false
            )
        } returns flowOf(londonWeather)

        viewModel = HomeViewModel(
            getWeatherUseCase,
            sharedPreferences
        )

        advanceUntilIdle()

        viewModel.loadWeather("London")

        advanceUntilIdle()

        assertEquals(
            londonWeather,
            viewModel.uiState.value.weather
        )
    }

    @Test
    fun `refresh uses force refresh`() = runTest {

        val weather = mockk<Weather>()

        every {
            getWeatherUseCase(any(), any())
        } returns flowOf(weather)

        viewModel = HomeViewModel(
            getWeatherUseCase,
            sharedPreferences
        )

        advanceUntilIdle()

        viewModel.loadWeather("London")

        advanceUntilIdle()

        viewModel.refreshWeather()

        advanceUntilIdle()

        verify {
            getWeatherUseCase(
                "London",
                true
            )
        }
    }

    @Test
    fun `loading same city twice does not reload`() = runTest {

        val weather = mockk<Weather>()

        every {
            getWeatherUseCase(any(), any())
        } returns flowOf(weather)

        viewModel = HomeViewModel(
            getWeatherUseCase,
            sharedPreferences
        )

        advanceUntilIdle()

        viewModel.loadWeather("London")

        advanceUntilIdle()

        viewModel.loadWeather("London")

        advanceUntilIdle()

        verify(exactly = 1) {
            getWeatherUseCase(
                "London",
                false
            )
        }
    }
}