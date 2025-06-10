package com.android.weatherapp.domain.entity

data class HourlyWeather(
    val weatherImgCode:Int,
    val temperature:Double,
    val time:String
)