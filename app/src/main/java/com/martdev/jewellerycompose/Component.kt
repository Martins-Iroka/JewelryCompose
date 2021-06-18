package com.martdev.jewellerycompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.martdev.jewellerycompose.ui.theme.ChildGradiant3

@Composable
fun ButtonView(modifier: Modifier, text: String) {
    Box(
        modifier
            .size(width = 303.dp, 62.dp)
            .clip(RoundedCornerShape(17.dp))
            .background(
                brush = Brush.linearGradient(ChildGradiant3)
            ),
        contentAlignment = Alignment.Center) {

        Text(text = text,
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = fontFamily(R.font.merriweather_bold)
        )
    }
}