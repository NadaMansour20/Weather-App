package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.weatherapp.R
import com.android.weatherapp.data.model.Current

@Composable
fun CurrentWeatherDetails(wind:String,humidity:String,rain:String,uv:String,pressure:String,feelsLike:String) {

    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally

        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            CurrentWeatherDetailsItem(
                iconId = R.drawable.fast_wind,
                temp = wind,
                discriptionId = R.string.Wind,
                modifier = Modifier.weight(1f)
            )
            CurrentWeatherDetailsItem(
                iconId = R.drawable.humidity,
                temp = humidity,
                discriptionId = R.string.Humidity,
                modifier = Modifier.weight(1f)

            )
            CurrentWeatherDetailsItem(
                iconId = R.drawable.rain,
                temp = rain,
                discriptionId =R.string.Rain,
                modifier = Modifier.weight(1f)

            )

        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)

        ){
            CurrentWeatherDetailsItem(
                iconId = R.drawable.uv_02,
                temp = uv,
                discriptionId = R.string.UV_Index,
                modifier = Modifier.weight(1f)

            )
            CurrentWeatherDetailsItem(
                iconId = R.drawable.arrow_down_05,
                temp = pressure,
                discriptionId =R.string.Pressure,
                modifier = Modifier.weight(1f)

            )
            CurrentWeatherDetailsItem(
                iconId = R.drawable.temperature,
                temp = feelsLike,
                discriptionId = R.string.Feels_like,
                modifier = Modifier.weight(1f)

            )

        }

    }
}