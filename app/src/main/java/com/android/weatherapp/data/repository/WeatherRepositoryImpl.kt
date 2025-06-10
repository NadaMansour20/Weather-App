package com.android.weatherapp.data.repository

import android.app.Activity
import com.android.weatherapp.data.location.GetCurrentLocation
import com.android.weatherapp.data.mapper.toUi
import com.android.weatherapp.data.remote.datasource.WeatherService
import com.android.weatherapp.domain.entity.Weather
import com.android.weatherapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherService: WeatherService,
) : WeatherRepository {

    override suspend fun getWeatherForCast(lat: Double, lang: Double): Weather {
        val response = weatherService.getWeatherForecast(lat, lang)
        return response.toUi("")
    }

}