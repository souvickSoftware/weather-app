package com.souvick.weatherapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.souvick.weatherapp.data.local.entity.HourlyForecastEntity
import com.souvick.weatherapp.data.local.entity.DailyForecastEntity
import com.souvick.weatherapp.data.local.entity.WeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    // Current Weather
    @Query("SELECT * FROM weather WHERE cityKey = :city")
    fun observeCurrentWeather(city: String): Flow<WeatherEntity?>

    @Query("SELECT * FROM weather WHERE cityKey = :city")
    suspend fun getCurrentWeather(city: String): WeatherEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrentWeather(weather: WeatherEntity)





    // Hourly Forecast
    @Query("SELECT * FROM hourly_forecast WHERE cityKey = :city ORDER BY time")
    fun observeHourlyForecast(city: String): Flow<List<HourlyForecastEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHourlyForecast(hourly: List<HourlyForecastEntity>)

    @Query("DELETE FROM hourly_forecast WHERE cityKey = :city")
    suspend fun deleteHourlyForecast(city: String)





    // Daily Forecast
    @Query("SELECT * FROM daily_forecast WHERE cityKey = :city ORDER BY date")
    fun observeDailyForecast(city: String): Flow<List<DailyForecastEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDailyForecast(daily: List<DailyForecastEntity>)

    @Query("DELETE FROM daily_forecast WHERE cityKey = :city")
    suspend fun deleteDailyForecast(city: String)
}