# Weather App

A modern Android weather application built with **Jetpack Compose** following **Clean Architecture** principles. 
The app provides current weather conditions, a 24-hour forecast, and a 7-day forecast with an **offline-first** experience powered by Room caching.

## Features

- Current weather
- Next 24-hour forecast
- 7-day forecast
- City search
- Offline-first caching
- Manual refresh

## Tech Stack

- Kotlin
- Jetpack Compose
- Clean Architecture (MVVM)
- Hilt
- Retrofit + OkHttp
- Room
- Kotlin Coroutines & Flow
- Kotlin Serialization

## Architecture

```
Presentation (Compose + ViewModel)
            │
            ▼
      GetWeatherUseCase
            │
            ▼
    WeatherRepository
       │          │
       ▼          ▼
     Room     WeatherAPI
```

The UI observes the local database while the repository manages cache expiration and API synchronization.

## Setup

1. Clone the repository.
2. Add your WeatherAPI key to `local.properties`.

```properties
WEATHER_API_KEY=YOUR_API_KEY
```

3. Build and run the project.

## Assumptions

- Weather data is cached locally and refreshed only after the configured TTL expires.
- Manual refresh bypasses the cache.
- Cached weather is displayed if the network is unavailable.
- The last selected city is restored on the next app launch.

## Future Improvements

- Pull-to-refresh
- Multiple saved locations
- Background sync using WorkManager
- Dynamic weather backgrounds
- Graceful error handling
- Improved test coverage
