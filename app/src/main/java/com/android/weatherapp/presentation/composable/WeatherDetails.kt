package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.weatherapp.R

@Preview(showSystemUi = true)
@Composable
fun WeatherDetails() {

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.width(336.dp).height(236.dp)

        ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            WeatherDetailsItem(
                iconId = R.drawable.fast_wind,
                temp = 455,
                discriptionId = 445,
                modifier = Modifier.weight(1f)
            )
            WeatherDetailsItem(
                iconId = R.drawable.humidity,
                temp = 78,
                discriptionId = 445,
                modifier = Modifier.weight(1f)

            )
            WeatherDetailsItem(
                iconId = R.drawable.rain,
                temp = 457,
                discriptionId = 45222,
                modifier = Modifier.weight(1f)

            )

        }
        Row (modifier = Modifier.fillMaxWidth()){
            WeatherDetailsItem(
                iconId = R.drawable.uv_02,
                temp = 5666,
                discriptionId = 1032474,
                modifier = Modifier.weight(1f)

            )
            WeatherDetailsItem(
                iconId = R.drawable.arrow_down_05,
                temp = 457,
                discriptionId = 756,
                modifier = Modifier.weight(1f)

            )
            WeatherDetailsItem(
                iconId = R.drawable.temperature,
                temp = 744,
                discriptionId = 741,
                modifier = Modifier.weight(1f)

            )

        }

    }
}