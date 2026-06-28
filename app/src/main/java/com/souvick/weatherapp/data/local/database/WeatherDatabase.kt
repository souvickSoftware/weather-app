package com.souvick.weatherapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.souvick.weatherapp.data.local.dao.WeatherDao
import com.souvick.weatherapp.data.local.entity.DailyForecastEntity
import com.souvick.weatherapp.data.local.entity.HourlyForecastEntity
import com.souvick.weatherapp.data.local.entity.WeatherEntity

@Database(
    entities = [
        WeatherEntity::class,
        HourlyForecastEntity::class,
        DailyForecastEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

}