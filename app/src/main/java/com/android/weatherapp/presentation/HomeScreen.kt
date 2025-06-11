package com.android.weatherapp.presentation

import android.app.Activity
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.android.weatherapp.R
import com.android.weatherapp.presentation.composable.CurrentWeatherDetails
import com.android.weatherapp.presentation.composable.LocationName
import com.android.weatherapp.presentation.composable.Title
import com.android.weatherapp.presentation.composable.ToDayCards
import com.android.weatherapp.presentation.composable.WeaklyForcast
import com.android.weatherapp.presentation.composable.WeatherImg
import com.android.weatherapp.presentation.composable.WeatherInfo
import com.android.weatherapp.presentation.state.HomeUiState
import com.android.weatherapp.presentation.viewmodel.HomeViewModel
import com.android.weatherapp.ui.theme.DarkCustomColors
import com.android.weatherapp.ui.theme.LightCustomColors
import com.android.weatherapp.ui.theme.LocalCustomColors
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    onDayStateChanged: (Int) -> Unit

) {

    val state by viewModel.state.collectAsState()
    val is_loading by viewModel.is_loading.collectAsState()

    val context = LocalContext.current
    val activity = context as? Activity
    LaunchedEffect(Unit) {
        activity?.let {
            viewModel.loadLocationAndForecast(it)
        }
    }

    LaunchedEffect(state.is_day) {
        onDayStateChanged(state.is_day)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        if (is_loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))

        } else {
            HomeContent(state = state)
        }
    }
}

@Composable
fun HomeContent(state: HomeUiState) {

    val scrollState = rememberScrollState()
    val density = LocalDensity.current
    val screenHeightPx = with(density) { LocalConfiguration.current.screenHeightDp.dp.toPx() }

    var isLarge by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        snapshotFlow { scrollState.value }
            .collect { scrollValue ->
                isLarge = scrollValue <= screenHeightPx / 9.9
            }
    }

    val animateIconSize by animateSizeAsState(
        targetValue = if (isLarge) Size(width = 220.21f, height = 200f) else Size(124f, 112f),
    )

    val animateIconOffset by animateIntOffsetAsState(
        targetValue = if (isLarge) IntOffset(0, 0) else IntOffset(-250, 200),
    )

    val animateInfoOffset by animateIntOffsetAsState(
        targetValue = if (isLarge) IntOffset(0, 0) else IntOffset(250, -250),
    )

    val animateLeftUp by animateIntOffsetAsState(
        targetValue = if (isLarge) IntOffset(0, 0) else IntOffset(0, -160),
    )

    val backgroundGradient = when (val customColors = LocalCustomColors.current) {
        is DarkCustomColors -> listOf(
            customColors.backgroundDarkGradient1,
            customColors.backgroundDarkGradient2
        )

        is LightCustomColors -> listOf(customColors.backgroundColor, customColors.White)
        else -> listOf(Color.Gray, Color.Black)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = backgroundGradient))
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            LocationName(
                modifier = Modifier.padding(top = 24.dp),
                cityName = state.address
            )

            WeatherImg(
                currentWeatherImg = state.currentWeatherImgId,
                modifier = Modifier
                    .width(animateIconSize.width.dp)
                    .height(animateIconSize.height.dp)
                    .offset { animateIconOffset }
            )

            WeatherInfo(
                currentTemp = state.currentTemperature,
                description = state.weatherDescription,
                tempMax = state.currentTempMax,
                tempMin = state.currentTempMin,
                modifier = Modifier.offset { animateInfoOffset }
            )

            Column(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .offset { animateLeftUp }
            ) {
                CurrentWeatherDetails(
                    wind = state.windSpeed,
                    humidity = state.humidity,
                    rain = state.rain,
                    uv = state.uv,
                    pressure = state.pressure,
                    feelsLike = state.temperature
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp)
                    .offset { animateLeftUp }
            ) {
                Title(R.string.today)
            }

            LazyRow(
                modifier = Modifier
                    .offset { animateLeftUp },
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 12.dp)
            ) {
                items(state.hourUiState.size) { index ->
                    ToDayCards(hourState = state.hourUiState[index])
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .offset { animateLeftUp }
            ) {
                Title(R.string.next7day)
                WeaklyForcast(days = state.dayUiState)
                Spacer(modifier = Modifier.padding(bottom = 32.dp))
            }
        }
    }
}


