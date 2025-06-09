package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.weatherapp.ui.theme.Gray8
import com.android.weatherapp.ui.theme.White70

@Preview(showSystemUi = true)
@Composable
fun WeaklyForcast(){
    Box(
        modifier = Modifier.height(435.dp)
            .border(0.25.dp, Gray8, shape = RoundedCornerShape(24.dp))
            .clip(RoundedCornerShape(24.dp))
            .background(White70)
            .padding(vertical = 4.dp)
    ) {
        Column(
//            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            WeaklyForcastItem()
            WeaklyForcastItem()
            WeaklyForcastItem()
            WeaklyForcastItem()
            WeaklyForcastItem()
            WeaklyForcastItem()
            WeaklyForcastItem()



        }
    }
}