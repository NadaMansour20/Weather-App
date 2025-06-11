package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.weatherapp.presentation.state.DayUiState
import com.android.weatherapp.ui.theme.DarkCustomColors
import com.android.weatherapp.ui.theme.Gray24
import com.android.weatherapp.ui.theme.Gray8
import com.android.weatherapp.ui.theme.LightCustomColors
import com.android.weatherapp.ui.theme.LocalCustomColors
import com.android.weatherapp.ui.theme.White70

@Composable
fun WeaklyForcast(days:List<DayUiState>){

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

    Box(
        modifier = Modifier.fillMaxWidth().height(435.dp)
            .border(1.dp, borderColor, shape = RoundedCornerShape(24.dp))
            .clip(RoundedCornerShape(24.dp))
            .background(cardBackgroundColor)
            .padding(vertical = 4.dp)
    ) {
        Column(
//            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            days.forEachIndexed { index, day ->
                WeaklyForcastItem(day = day)
                if (index != days.lastIndex) {
                    lineBetweenCard(borderColor)
                }
            }

        }
    }
}


@Composable
fun lineBetweenCard(borderColor:Color){

    Box(

        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .border(1.dp, borderColor)

    )
}