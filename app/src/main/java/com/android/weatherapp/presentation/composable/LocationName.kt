package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.weatherapp.R
import com.android.weatherapp.ui.theme.DarkCustomColors
import com.android.weatherapp.ui.theme.Gray
import com.android.weatherapp.ui.theme.LightCustomColors
import com.android.weatherapp.ui.theme.LocalCustomColors
import com.android.weatherapp.ui.theme.urbanist

@Composable
fun LocationName(modifier: Modifier=Modifier,cityName:String){

    val customColors = LocalCustomColors.current

    val color = when (customColors) {
        is DarkCustomColors -> customColors.White
        is LightCustomColors -> customColors.Gray
        else -> Color.Gray
    }


    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)

    ){
        Icon(
            painter = painterResource(R.drawable.location),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = color
        )

        Text(
            text = cityName,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp,
            color = color,
            fontWeight= FontWeight.Medium,
            fontFamily = urbanist ,

        )
    }
}