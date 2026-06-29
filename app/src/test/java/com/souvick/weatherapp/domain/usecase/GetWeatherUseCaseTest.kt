package com.souvick.weatherapp.domain.usecase

import app.cash.turbine.test
import com.souvick.weatherapp.domain.model.Weather
import com.souvick.weatherapp.domain.repository.WeatherRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetWeatherUseCaseTest {

    private val repository = mockk<WeatherRepository>()

    private lateinit var useCase: GetWeatherUseCase

    @Before
    fun setup() {
        useCase = GetWeatherUseCase(repository)
    }

    @Test
    fun `invoke returns weather from repository`() = runTest {

        val weather = mockk<Weather>()

        every {
            repository.getWeather(
                "London",
                false
            )
        } returns flowOf(weather)

        useCase("London").test {

            assertEquals(weather, awaitItem())

            awaitComplete()

        }

    }
}