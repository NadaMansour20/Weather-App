package com.android.weatherapp.presentation.viewmodel

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.weatherapp.data.mapper.WeatherDescriptionCodeMapper
import com.android.weatherapp.data.mapper.WeatherIconMapper
import com.android.weatherapp.domain.repository.WeatherRepository
import com.android.weatherapp.domain.usecase.GetAddressUseCase
import com.android.weatherapp.domain.usecase.GetLocationUseCase
import com.android.weatherapp.presentation.state.DayUiState
import com.android.weatherapp.presentation.state.HomeUiState
import com.android.weatherapp.presentation.state.HourUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.mp.KoinPlatform.getKoin
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HomeViewModel(
    private val weatherRepository: WeatherRepository,
    private val getLocation: GetLocationUseCase = getKoin().get(),
    private val getAddress: GetAddressUseCase = getKoin().get()
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    val is_loading = MutableStateFlow(true)

    fun loadLocationAndForecast(activity: Activity) {
        is_loading.value=true
        viewModelScope.launch(Dispatchers.IO) {
            val location = getLocation(activity)
            if (location != null) {
                val address = getAddress(activity, location.latitude, location.longitude)
                if (address != null) {
                    is_loading.value=false
                    getForecast(location.latitude, location.longitude, address)
                }
            }
        }
    }

    fun getForecast(lat: Double, lon: Double, address: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val weather = weatherRepository.getWeatherForCast(lat, lon)

                val hourUiState = weather.hourWeather.map {
                    HourUiState(
                        weatherImgId = WeatherIconMapper(it.weatherImgCode, weather.is_day),
                        temperature = it.temperature,
                        time = it.time
                    )
                }

                val dayUiState = weather.dailyWeather.map {
                    DayUiState(
                        temperatureMax = "${it.temperatureMax}°",
                        temperatureMin = "${it.temperatureMin}°",
                        weatherImgId = WeatherIconMapper(it.weatherImgCode, 1),
                        dayName = formatDate(it.date)
                    )
                }

                _state.update {
                    it.copy(
                        address = address,
                        weatherDescription = WeatherDescriptionCodeMapper(weather.currentWeatherDescriptionCode),
                        currentTempMax = weather.currentTempMax,
                        currentTempMin = weather.currentTempMin,
                        currentWeatherImgId = WeatherIconMapper(weather.currentWeatherImgCode, weather.is_day),
                        currentTemperature = weather.currentTemperature,
                        windSpeed = weather.windSpeed,
                        humidity = weather.humidity,
                        rain = weather.rain,
                        uv = weather.uv,
                        pressure = weather.pressure,
                        temperature = weather.temperature,
                        is_day = weather.is_day,
                        hourUiState = hourUiState,
                        dayUiState = dayUiState
                    )
                }
            } catch (e: Exception) {
                throw Exception(e.message)
            }
        }
    }

    private fun formatDate(date: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val localDate = LocalDate.parse(date, formatter)
        return localDate.dayOfWeek.name.lowercase()
            .replaceFirstChar { it.uppercase() }
    }

}
