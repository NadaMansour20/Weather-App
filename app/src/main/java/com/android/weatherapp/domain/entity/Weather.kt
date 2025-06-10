package com.android.weatherapp.domain.entity

import com.android.weatherapp.presentation.state.DayUiState
import com.android.weatherapp.presentation.state.HourUiState

data class Weather(


    val address: String,
    val currentWeatherDescriptionCode: Int,
    val currentWeatherImgCode: Int,
    val currentTempMax: Double,
    val currentTempMin: Double,
    val currentTemperature: Double,

    val windSpeed: String,
    val humidity: String,
    val rain: String,
    val uv: String,
    val pressure: String,
    val temperature: String,

    val is_day: Int,

    val hourWeather: List<HourlyWeather>,
    val dailyWeather: List<DailyWeather>
)
