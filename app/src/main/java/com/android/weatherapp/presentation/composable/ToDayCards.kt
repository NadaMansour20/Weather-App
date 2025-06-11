package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.android.weatherapp.R
import com.android.weatherapp.data.mapper.WeatherIconMapper
import com.android.weatherapp.presentation.state.HourUiState
import com.android.weatherapp.ui.theme.Black60
import com.android.weatherapp.ui.theme.Black87
import com.android.weatherapp.ui.theme.DarkCustomColors
import com.android.weatherapp.ui.theme.Gray8
import com.android.weatherapp.ui.theme.LightCustomColors
import com.android.weatherapp.ui.theme.LocalCustomColors
import com.android.weatherapp.ui.theme.White70
import com.android.weatherapp.ui.theme.urbanist


@Composable
fun ToDayCards(hourState:HourUiState) {

    val customColors = LocalCustomColors.current
    val temperatureColor = when (customColors) {
        is DarkCustomColors -> customColors.White87
        is LightCustomColors -> customColors.Black87
        else -> Color.Black
    }

    val timeColor = when (customColors) {
        is DarkCustomColors -> customColors.White60
        is LightCustomColors -> customColors.Black60
        else -> Color.Gray
    }

    val borderColor = when (customColors) {
        is DarkCustomColors -> customColors.White8
        is LightCustomColors -> customColors.Gray8
        else -> Color.Gray
    }
    val cardBackgroundColor = when (customColors) {
        is DarkCustomColors -> customColors.Black70
        is LightCustomColors -> customColors.White70
        else -> Color.Gray
    }



    Box(
        modifier = Modifier.size(width = 95.dp, height = 140.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.size(width = 80.dp, height = 75.dp)
                .offset(y = -40.dp)
                .zIndex(1f)
                .padding(start = 12.dp, end = 18.dp)
        ) {
            Image(
                painter = painterResource(hourState.weatherImgId),
                contentDescription = null,
                modifier = Modifier.size(width = 64.dp, height = 58.dp)

            )
        }


        Box (
            modifier = Modifier
                .size(width = 88.dp, height = 120.dp)
                .border(1.dp, borderColor, RoundedCornerShape(20.dp))
                .background(cardBackgroundColor, RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier.padding(top = 32.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = hourState.temperature.toString(),
                    fontSize = 16.sp,
                    letterSpacing = 0.25.sp,
                    fontFamily = urbanist ,
                    fontWeight = FontWeight.Medium,
                    color = temperatureColor


                    )
                Text(
                    text = hourState.time,
                    fontSize = 16.sp,
                    letterSpacing = 0.25.sp,
                    fontFamily = urbanist ,
                    fontWeight = FontWeight.Medium,
                    color = timeColor

                )

            }
        }


    }

}
