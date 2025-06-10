package com.android.weatherapp.data.remote.datasource

import com.android.weatherapp.data.model.WeatherApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface WeatherService {

    suspend fun getWeatherForecast(
        lat: Double,
        lon: Double
    ): WeatherApiResponse

    companion object {
        fun create(): WeatherService {
            val client = HttpClient(Android) {
                install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                            isLenient = true
                        }
                    )
                }
                install(Logging) {
                    logger = Logger.DEFAULT
                    level = LogLevel.ALL
                }
            }
            return WeatherServiceImpl(client)
        }
    }
}