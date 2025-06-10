package com.android.weatherapp.domain.usecase

import com.android.weatherapp.domain.entity.Weather
import com.android.weatherapp.domain.repository.WeatherRepository

class GetWeatherForecastUseCase(
    private val weatherRepository: WeatherRepository
){

    suspend operator fun invoke(lat:Double, lang:Double):Weather{

        return weatherRepository.getWeatherForCast(lat,lang)
    }

}