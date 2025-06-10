package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.weatherapp.ui.theme.Black
import com.android.weatherapp.ui.theme.Black60
import com.android.weatherapp.ui.theme.Gray8
import com.android.weatherapp.ui.theme.urbanist

@Composable
fun WeatherInfo(currentTemp:Double,description:String,tempMax:Double,tempMin:Double) {

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
                    color = Black

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
                    color = Black60

                )
            }
        }


        TempretureRange(tempMax.toString(), tempMin.toString(), Black60, Black60, Gray8,8,24,8)


    }

}