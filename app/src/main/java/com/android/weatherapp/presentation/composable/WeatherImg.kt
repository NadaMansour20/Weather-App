package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.weatherapp.R

@Composable
fun WeatherImg(currentWeatherImg:Int,modifier: Modifier=Modifier){

    Image(
        painter = painterResource(currentWeatherImg),
        contentDescription = null,
        modifier = modifier.size(width = 220.21.dp, height = 200.dp)

    )
}