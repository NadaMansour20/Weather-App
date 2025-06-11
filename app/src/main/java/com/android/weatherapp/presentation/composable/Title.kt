package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.android.weatherapp.ui.theme.Black
import com.android.weatherapp.ui.theme.DarkCustomColors
import com.android.weatherapp.ui.theme.LightCustomColors
import com.android.weatherapp.ui.theme.LocalCustomColors
import com.android.weatherapp.ui.theme.urbanist

@Composable
fun Title(titleId:Int){
    val customColors = LocalCustomColors.current

    val textColor = when (customColors) {
        is DarkCustomColors -> customColors.White
        is LightCustomColors -> customColors.Black
        else -> Color.Black
    }


    Text(
        text = stringResource(titleId),
        fontSize = 20.sp,
        letterSpacing = 0.25.sp,
        fontFamily = urbanist ,
        fontWeight = FontWeight.SemiBold,
        color = textColor,
        modifier = Modifier.fillMaxSize()
    )
}