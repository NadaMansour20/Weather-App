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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.zIndex
import com.android.weatherapp.R
import com.android.weatherapp.ui.theme.Black
import com.android.weatherapp.ui.theme.Black60
import com.android.weatherapp.ui.theme.Black87
import com.android.weatherapp.ui.theme.BlueLight
import com.android.weatherapp.ui.theme.Gray8
import com.android.weatherapp.ui.theme.White70

@Preview(showBackground = true)
@Composable
fun ToDayCards(){

    Box(
        modifier = Modifier.size(width = 95.dp, height = 140.dp),
        contentAlignment = Alignment.Center
    ){
    Column(
        modifier = Modifier.size(width = 88.dp, height = 120.dp)
            .border(1.dp, Gray8, RoundedCornerShape(20.dp))
            .background(White70, RoundedCornerShape(20.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.offset(y = -12.dp).zIndex(1f)
                .padding(start = 12.dp, end = 18.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.sun),
                contentDescription = null,
                modifier = Modifier.size(58.dp)

            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "25 C",
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
//            fontFamily = ,
                fontWeight = FontWeight.Medium,
                color = Black87

            )
            Text(
                text = "11:00",
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
//            fontFamily = ,
                fontWeight = FontWeight.Medium,
                color = Black60

            )

        }
    }


    }

}

@Composable
fun RecyclerToDayCards(){

    LazyRow(
        modifier = Modifier.height(168.dp).width(388.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(3){
            ToDayCards()
        }

    }
}