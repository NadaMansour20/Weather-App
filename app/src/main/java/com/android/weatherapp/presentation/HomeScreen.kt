package com.android.weatherapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.weatherapp.R
import com.android.weatherapp.presentation.composable.LocationName
import com.android.weatherapp.presentation.composable.Title
import com.android.weatherapp.presentation.composable.WeaklyForcast
import com.android.weatherapp.presentation.composable.WeatherDetails
import com.android.weatherapp.presentation.composable.WeatherImg
import com.android.weatherapp.presentation.composable.WeatherInfo
import com.android.weatherapp.ui.theme.backgroundColor


//.padding(WindowInsets.systemBars.asPaddingValues())
@Preview(
    name = "My Device Preview",
    device = Devices.PIXEL_7_PRO,
    showSystemUi = true,
    showBackground = true
)
@Composable
fun HomeScreen() {

    Column(
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
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),

        ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            LocationName(
                modifier = Modifier.padding(top = 64.dp)
            )
            WeatherImg()
            WeatherInfo()
        }
        Column {
            WeatherDetails()

        }

        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.padding(start = 12.dp)

        ) {

            Title(R.string.today)


        }

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Title(R.string.next7day)
            WeaklyForcast()


        }
    }

}

