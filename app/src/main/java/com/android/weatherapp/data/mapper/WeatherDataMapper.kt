package com.android.weatherapp.data.mapper

import com.android.weatherapp.data.model.WeatherApiResponse
import com.android.weatherapp.domain.entity.DailyWeather
import com.android.weatherapp.domain.entity.HourlyWeather
import com.android.weatherapp.domain.entity.Weather

fun WeatherApiResponse.toUi(address: String): Weather {

    val isDay = this.current?.isDay ?: 1
    val hourWeather = this.hourly?.let { hourly ->
        val times = hourly.time ?: emptyList()
        val temps = hourly.temperature2m ?: emptyList()
        val codes = hourly.weatherCode ?: emptyList()

        times.indices.mapNotNull { i ->
            val time = times.getOrNull(i) ?: return@mapNotNull null
            val temp = temps.getOrNull(i) ?: return@mapNotNull null
            val code = codes.getOrNull(i) ?: return@mapNotNull null

            HourlyWeather(
                weatherImgCode = code,
                temperature = temp,
                time = time.substringAfter("T")
            )
        }
    } ?: emptyList()

    val dailyWeather = this.daily?.let { daily ->
        val dates = daily.time ?: emptyList()
        val maxTemps = daily.temperature2mMax ?: emptyList()
        val minTemps = daily.temperature2mMin ?: emptyList()
        val codes = daily.weatherCode ?: emptyList()

        dates.indices.mapNotNull { i ->
            val date = dates.getOrNull(i) ?: return@mapNotNull null
            val maxTemp = maxTemps.getOrNull(i) ?: return@mapNotNull null
            val minTemp = minTemps.getOrNull(i) ?: return@mapNotNull null
            val code = codes.getOrNull(i) ?: return@mapNotNull null

            DailyWeather(
                weatherImgCode = code,
                temperatureMax = maxTemp,
                temperatureMin = minTemp,
                date = date
            )
        }
    } ?: emptyList()

    return Weather(
        address = address,
        currentWeatherDescriptionCode = this.current?.weatherCode ?: 0,
        currentWeatherImgCode = this.current?.weatherCode ?: 0,
        currentTempMax = this.daily?.temperature2mMax?.firstOrNull() ?: 0.0,
        currentTempMin = this.daily?.temperature2mMin?.firstOrNull() ?: 0.0,
        currentTemperature = this.current?.temperature2m ?: 0.0,
        windSpeed = "${this.current?.windSpeed10m ?: 0.0} km/h",
        humidity = "${this.current?.relativeHumidity2m ?: 0}%",
        rain = "${this.current?.rain ?: 0.0}%",
        uv = this.daily?.uvIndexMax?.firstOrNull()?.toString()?:"0",
        pressure = "${this.current?.surfacePressure?:0.0} hPa",
        temperature = "${this.current?.apparentTemperature ?: 0.0}°C",
        is_day = isDay,
        hourWeather = hourWeather,
        dailyWeather = dailyWeather
    )
}