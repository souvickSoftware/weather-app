package com.souvick.weatherapp.data.remote.api

import com.souvick.weatherapp.data.remote.dto.ForecastResponseDTO
import com.souvick.weatherapp.data.remote.dto.SearchCityDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast.json")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("days") days: Int = 7,
        @Query("aqi") aqi: String = "yes",
        @Query("alerts") alerts: String = "yes"
    ): ForecastResponseDTO

    @GET("v1/search.json")
    suspend fun searchCities(
        @Query("q") query: String
    ): List<SearchCityDTO>
}