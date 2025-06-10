package com.android.weatherapp.presentation.state

import com.android.weatherapp.R

data class HomeUiState(

    val address: String="",
    val weatherDescription: String="",
    val currentTempMax: Double=0.0,
    val currentTempMin: Double=0.0,
    val currentWeatherImgId: Int= R.drawable.light_mainly_clear,
    val currentTemperature: Double=0.0,

    val windSpeed: String="",
    val humidity: String="",
    val rain: String="",
    val uv: String="",
    val pressure: String="",
    val temperature: String="",

    val is_day: Int=0,

    val hourUiState: List<HourUiState> = listOf(),
    val dayUiState: List<DayUiState> = listOf()


)


data class HourUiState(
    val weatherImgId: Int=R.drawable.light_snow_fall_light,
    val temperature: Double=0.0,
    val time: String=""

)

data class DayUiState(
    val temperatureMax: String="",
    val temperatureMin: String="",
    val weatherImgId: Int=R.drawable.light_rain_slight,
    val dayName: String=""
)

