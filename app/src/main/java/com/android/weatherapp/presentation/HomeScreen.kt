package com.android.weatherapp.presentation

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.android.weatherapp.R
import com.android.weatherapp.data.location.GetCurrentAddress
import com.android.weatherapp.data.location.GetCurrentLocation
import com.android.weatherapp.data.repository.GetAddressImpl
import com.android.weatherapp.data.repository.GetLocationImpl
import com.android.weatherapp.data.remote.datasource.WeatherService
import com.android.weatherapp.domain.usecase.GetAddressUseCase
import com.android.weatherapp.domain.usecase.GetLocationUseCase
import com.android.weatherapp.presentation.composable.LocationName
import com.android.weatherapp.presentation.composable.Title
import com.android.weatherapp.presentation.composable.ToDayCards
import com.android.weatherapp.presentation.composable.WeaklyForcast
import com.android.weatherapp.presentation.composable.WeatherDetails
import com.android.weatherapp.presentation.composable.WeatherImg
import com.android.weatherapp.presentation.composable.WeatherInfo
import com.android.weatherapp.presentation.state.HomeUiState
import com.android.weatherapp.presentation.viewmodel.HomeViewModel
import com.android.weatherapp.ui.theme.backgroundColor
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.getKoin


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    getLocation: GetLocationUseCase = getKoin().get(),
    getAddress: GetAddressUseCase = getKoin().get()
) {
    val context = LocalContext.current
    val activity = context as Activity
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        val location = getLocation(activity)

        if (location != null) {
            val address = getAddress(activity, location.latitude, location.longitude)

            if (address != null) {
                viewModel.getForecast(location.latitude, location.longitude, address)

                Log.d("WeatherApp", "Location: ${location.latitude}, ${location.longitude}")
                Log.d("WeatherApp", "Address: $address")
            } else {
                Log.e("WeatherApp", "Address is null")
            }
        } else {
            Log.e("WeatherApp", "Location is null")
        }
    }
    HomeContent(state = state)
}

@Composable
fun HomeContent(state: HomeUiState) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        backgroundColor,
                        Color.White
                    )
                )
            ),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            item {
                LocationName(
                    modifier = Modifier.padding(top = 80.dp),
                    cityName = state.address,
                )
            }
            item {
                WeatherImg(
                    currentWeatherImg = state.currentWeatherImgId,
                )
            }
            item {
                WeatherInfo(
                    currentTemp = state.currentTemperature,
                    description = state.weatherDescription,
                    tempMax = state.currentTempMax,
                    tempMin = state.currentTempMin
                )
            }

            item {
                Column(
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    WeatherDetails(
                        wind = state.windSpeed,
                        humidity = state.humidity,
                        rain = state.rain,
                        uv = state.uv,
                        pressure = state.pressure,
                        feelsLike = state.temperature
                    )
                }


            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp)
                ) {
                    Title(R.string.today)
                }

            }

            item {

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp)
                ) {
                    items(state.hourUiState.size) { index ->
                        ToDayCards(hourState = state.hourUiState[index])
                    }
                }
            }
            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    Title(R.string.next7day)
                    WeaklyForcast(days = state.dayUiState)
                    Spacer(modifier = Modifier.padding(bottom = 32.dp))


                }
            }

        }

    }


}

