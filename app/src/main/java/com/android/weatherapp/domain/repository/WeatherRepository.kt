package com.android.weatherapp.domain.repository

import android.location.Location
import com.android.weatherapp.domain.entity.Weather

interface WeatherRepository {

   suspend fun getWeatherForCast(lat:Double,lang:Double):Weather
}