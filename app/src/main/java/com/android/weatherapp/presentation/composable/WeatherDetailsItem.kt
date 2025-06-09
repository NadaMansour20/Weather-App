package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.weatherapp.R
import com.android.weatherapp.ui.theme.Black60
import com.android.weatherapp.ui.theme.Black87
import com.android.weatherapp.ui.theme.BlueLight
import com.android.weatherapp.ui.theme.Gray8

@Composable
fun WeatherDetailsItem(iconId:Int,temp:Int,discriptionId:Int,modifier: Modifier=Modifier){

    Column(
        modifier = Modifier.size(width = 108.dp, height = 115.dp)
            .border(1.dp, Gray8, RoundedCornerShape(24.dp))
            .background(Color.White, RoundedCornerShape(24.dp))
            .padding(horizontal = 8.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Icon(
            painter = painterResource(iconId),
            contentDescription = null,
            tint = BlueLight,
            modifier = Modifier.size(32.dp)
        )
        Column(
            modifier = Modifier.size(width = 92.dp, height = 43.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = temp.toString(),
                fontSize = 20.sp,
                letterSpacing = 0.25.sp,
//            fontFamily = ,
                fontWeight = FontWeight.Medium,
                color = Black87

            )
            Text(
                text = discriptionId.toString(),
                fontSize = 14.sp,
                letterSpacing = 0.25.sp,
//            fontFamily = ,
                fontWeight = FontWeight.Normal,
                color = Black60

            )

        }



    }

}


