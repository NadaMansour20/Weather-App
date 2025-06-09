package com.android.weatherapp.presentation.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.weatherapp.R
import com.android.weatherapp.ui.theme.Gray24

@Composable
fun TempretureRange(
    rangeFrom: String,
    rangeTo: String,
    iconColor: Color,
    textColor: Color
) {

    Row(
        modifier = Modifier.width(103.dp).height(17.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Icon(
                painter = painterResource(R.drawable.arrow_up),
                contentDescription = null,
                modifier = Modifier.size(width = 12.dp, height = 12.dp),
                tint = iconColor

            )
            Text(
                text = rangeFrom,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
//            fontFamily = ,
                fontWeight = FontWeight.Medium,
                color = textColor

            )
        }
        Box(

            modifier = Modifier
                .width(1.dp)
                .height(14.dp)
                .border(1.dp, Gray24)

            )
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Icon(
                painter = painterResource(R.drawable.arrow_up),
                contentDescription = null,
                modifier = Modifier.size(width = 12.dp, height = 12.dp).rotate(180f),
                tint = iconColor

            )
            Text(
                text = rangeTo,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
//            fontFamily = ,
                fontWeight = FontWeight.Medium,
                color = textColor

            )
        }
    }
}