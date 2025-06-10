package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.android.weatherapp.ui.theme.Gray8
import com.android.weatherapp.ui.theme.White70
import com.android.weatherapp.ui.theme.urbanist

@Composable
fun ToDayCards(hourState:HourUiState) {

    Box(
        modifier = Modifier.size(width = 95.dp, height = 140.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.size(width = 64.dp, height = 58.dp)
                .offset(y = -53.dp)
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
                .border(1.dp, Gray8, RoundedCornerShape(20.dp))
                .background(White70, RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = hourState.temperature.toString(),
                    fontSize = 16.sp,
                    letterSpacing = 0.25.sp,
                    fontFamily = urbanist ,
                    fontWeight = FontWeight.Medium,
                    color = Black87

                )
                Text(
                    text = hourState.time,
                    fontSize = 16.sp,
                    letterSpacing = 0.25.sp,
                    fontFamily = urbanist ,
                    fontWeight = FontWeight.Medium,
                    color = Black60

                )

            }
        }


    }

}
