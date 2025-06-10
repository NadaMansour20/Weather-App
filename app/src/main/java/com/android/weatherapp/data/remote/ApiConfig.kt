package com.android.weatherapp.data.remote

object ApiConfig {
    const val BASE_URL = "https://api.open-meteo.com/v1/forecast"
    const val PARAMETERS = "&daily=uv_index_max,weather_code,temperature_2m_max,temperature_2m_min,rain_sum,apparent_temperature_max,apparent_temperature_min" +
            "&hourly=temperature_2m,weather_code" +
            "&current=rain,weather_code,temperature_2m,is_day,wind_speed_10m,apparent_temperature,relative_humidity_2m,surface_pressure" +
            "&timezone=auto"
}


