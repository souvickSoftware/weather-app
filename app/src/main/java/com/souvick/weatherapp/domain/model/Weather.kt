package com.souvick.weatherapp.domain.model

data class Weather(

    val current: CurrentWeather,

    val hourly: List<HourlyWeather>,

    val daily: List<DailyWeather>
)