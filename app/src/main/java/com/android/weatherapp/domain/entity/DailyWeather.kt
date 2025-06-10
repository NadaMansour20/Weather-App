package com.android.weatherapp.domain.entity

data class DailyWeather(
    val weatherImgCode:Int,
    val temperatureMax:Double,
    val temperatureMin:Double,
    val date:String
)