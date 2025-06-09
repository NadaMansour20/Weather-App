package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.weatherapp.ui.theme.Black
import com.android.weatherapp.ui.theme.Black60
import com.android.weatherapp.ui.theme.Gray8

@Preview(showSystemUi = true)
@Composable
fun WeatherInfo() {

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
                    text = "24 C",
                    fontSize = 64.sp,
                    letterSpacing = 0.25.sp,
//            fontFamily = ,
                    fontWeight = FontWeight.SemiBold,
                    color = Black

                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Partly cloudy",
                    fontSize = 16.sp,
                    letterSpacing = 0.25.sp,
//            fontFamily = ,
                    fontWeight = FontWeight.Medium,
                    color = Black60

                )
            }
        }
        Row(
            modifier = Modifier
                .background(Gray8, RoundedCornerShape(100.dp))
                .size(width = 168.dp, 35.dp)
                .padding(top = 8.dp, start = 24.dp, end = 24.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {

            TempretureRange("32 C", "20 C", Black60, Black60)

        }

    }

}