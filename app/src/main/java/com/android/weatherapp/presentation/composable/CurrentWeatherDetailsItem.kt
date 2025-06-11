package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import com.android.weatherapp.ui.theme.Black60
import com.android.weatherapp.ui.theme.Black87
import com.android.weatherapp.ui.theme.BlueLight
import com.android.weatherapp.ui.theme.DarkCustomColors
import com.android.weatherapp.ui.theme.LightCustomColors
import com.android.weatherapp.ui.theme.LocalCustomColors
import com.android.weatherapp.ui.theme.urbanist

@Composable
fun CurrentWeatherDetailsItem(iconId: Int, temp:String, discriptionId: Int, modifier: Modifier = Modifier) {

    val customColors = LocalCustomColors.current

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

    val tempDetailsColor = when (customColors) {
        is DarkCustomColors -> customColors.White87
        is LightCustomColors -> customColors.Black87
        else -> Color.Gray
    }
    val titleColor = when (customColors) {
        is DarkCustomColors -> customColors.White60
        is LightCustomColors -> customColors.Black60
        else -> Color.Gray
    }



    Box(
        modifier = modifier.fillMaxWidth()
            .border(1.dp, borderColor, RoundedCornerShape(24.dp))
            .background(cardBackgroundColor, RoundedCornerShape(24.dp))
            .padding(horizontal = 8.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                painter = painterResource(iconId),
                contentDescription = null,
                tint = BlueLight,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.padding(bottom = 8.dp))

            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

                ){
                Text(
                    text = temp,
                    fontSize = 20.sp,
                    letterSpacing = 0.25.sp,
                    fontFamily = urbanist,
                    fontWeight = FontWeight.Medium,
                    color = tempDetailsColor

                )
                Spacer(modifier = Modifier.padding(bottom = 2.dp))
                Text(
                    text = stringResource(discriptionId),
                    fontSize = 14.sp,
                    letterSpacing = 0.25.sp,
                    fontFamily = urbanist,
                    fontWeight = FontWeight.Normal,
                    color = titleColor

                )
            }

        }


    }

}


