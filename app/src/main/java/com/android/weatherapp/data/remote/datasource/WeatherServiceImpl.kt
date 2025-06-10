package com.android.weatherapp.data.remote.datasource


import com.android.weatherapp.data.model.WeatherApiResponse
import com.android.weatherapp.data.remote.ApiConfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class WeatherServiceImpl(
    private val client: HttpClient
) : WeatherService {
    override suspend fun getWeatherForecast(lat: Double, lon: Double): WeatherApiResponse {
        val url = "${ApiConfig.BASE_URL}?latitude=$lat&longitude=$lon${ApiConfig.PARAMETERS}"
        return try {
            client.get(url).body<WeatherApiResponse>()

        } catch (e: Exception) {
            throw Exception(e.message)
        }

    }

}

