package com.jarvis.assistant.data.repository

import com.jarvis.assistant.data.api.WeatherApiService
import com.jarvis.assistant.data.models.WeatherData

class WeatherRepository(private val weatherService: WeatherApiService) {
    suspend fun getWeatherByCity(city: String, apiKey: String): WeatherData? {
        return try {
            val response = weatherService.getWeatherByCity(city, apiKey)
            WeatherData(
                temperature = response.main.temp,
                description = response.weather.firstOrNull()?.description ?: "",
                humidity = response.main.humidity.toFloat(),
                windSpeed = response.wind.speed,
                city = response.name,
                country = "",
                icon = response.weather.firstOrNull()?.icon ?: ""
            )
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun getWeatherByLocation(lat: Double, lon: Double, apiKey: String): WeatherData? {
        return try {
            val response = weatherService.getWeather(lat, lon, apiKey)
            WeatherData(
                temperature = response.main.temp,
                description = response.weather.firstOrNull()?.description ?: "",
                humidity = response.main.humidity.toFloat(),
                windSpeed = response.wind.speed,
                city = response.name,
                country = "",
                icon = response.weather.firstOrNull()?.icon ?: ""
            )
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
