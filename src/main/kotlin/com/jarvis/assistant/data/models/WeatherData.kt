package com.jarvis.assistant.data.models

data class WeatherData(
    val temperature: Float,
    val description: String,
    val humidity: Float,
    val windSpeed: Float,
    val city: String,
    val country: String,
    val icon: String
)

data class WeatherResponse(
    val coord: Coordinates,
    val weather: List<Weather>,
    val main: MainWeatherData,
    val wind: Wind,
    val name: String
)

data class Coordinates(
    val lon: Float,
    val lat: Float
)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class MainWeatherData(
    val temp: Float,
    val feels_like: Float,
    val temp_min: Float,
    val temp_max: Float,
    val pressure: Int,
    val humidity: Int
)

data class Wind(
    val speed: Float,
    val deg: Int
)
