package com.android.weatherapp.domain.repository

import com.android.weatherapp.domain.entity.Weather

interface WeatherRepository {

    fun getWeather():Weather
}