package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.weatherapp.ui.theme.Black
import com.android.weatherapp.ui.theme.Black60
import com.android.weatherapp.ui.theme.DarkCustomColors
import com.android.weatherapp.ui.theme.Gray8
import com.android.weatherapp.ui.theme.LightCustomColors
import com.android.weatherapp.ui.theme.LocalCustomColors
import com.android.weatherapp.ui.theme.urbanist

@Composable
fun WeatherInfo(currentTemp:Double,description:String,tempMax:Double,tempMin:Double) {


    val customColors = LocalCustomColors.current

    val temperatureColor = when (customColors) {
        is DarkCustomColors -> customColors.White
        is LightCustomColors -> customColors.Black
        else -> Color.Black
    }

    val dicTempColor = when (customColors) {
        is DarkCustomColors -> customColors.White60
        is LightCustomColors -> customColors.Black60
        else -> Color.Gray
    }

    val tempMaxMinColor = when (customColors) {
        is DarkCustomColors -> customColors.White87
        is LightCustomColors -> customColors.Black60
        else -> Color.Gray
    }

    val backgroundColor = when (customColors) {
        is DarkCustomColors -> customColors.White8
        is LightCustomColors -> customColors.Gray8
        else -> Color.LightGray
    }





    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally


    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = currentTemp.toString(),
                    fontSize = 64.sp,
                    letterSpacing = 0.25.sp,
                    fontFamily = urbanist,
                    fontWeight = FontWeight.SemiBold,
                    color = temperatureColor

                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = description,
                    fontSize = 16.sp,
                    letterSpacing = 0.25.sp,
                    fontFamily = urbanist,
                    fontWeight = FontWeight.Medium,
                    color = dicTempColor

                )
            }
        }


        TempretureRange(tempMax.toString(), tempMin.toString(), tempMaxMinColor, tempMaxMinColor, backgroundColor,8,24,8)


    }

}