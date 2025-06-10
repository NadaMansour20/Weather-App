package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.android.weatherapp.R
import com.android.weatherapp.presentation.state.DayUiState
import com.android.weatherapp.ui.theme.Black60
import com.android.weatherapp.ui.theme.Black87
import com.android.weatherapp.ui.theme.Gray8
import com.android.weatherapp.ui.theme.White70
import com.android.weatherapp.ui.theme.urbanist

@Composable
fun WeaklyForcastItem(day: DayUiState) {


    Row(
        modifier = Modifier
            .height(61.dp)
            .fillMaxWidth()
//            .border(0.5.dp, Gray8)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = day.dayName,
             fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            fontFamily = urbanist ,
            fontWeight = FontWeight.Normal, color = Black60

        )
        Image(
            painter = painterResource(day.weatherImgId),
            contentDescription = null,
            modifier = Modifier.size(width = 91.dp, height = 45.dp)

        )

//        Row(
//            modifier = Modifier.size(width = 103.dp, 17.dp),
//            horizontalArrangement = Arrangement.spacedBy(4.dp),
//
//            ) {

            TempretureRange(day.temperatureMax, day.temperatureMin, Black87, Black87, Color.Transparent,0,0,4)

//        }

    }


}