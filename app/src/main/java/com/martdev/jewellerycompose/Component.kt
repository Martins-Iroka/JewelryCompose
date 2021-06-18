package com.martdev.jewellerycompose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.martdev.jewellerycompose.ui.theme.ChildGradiant
import com.martdev.jewellerycompose.ui.theme.ChildGradiant3
import com.martdev.jewellerycompose.ui.theme.TextColor
import com.martdev.jewellerycompose.ui.theme.TextColor6

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

@Composable
fun ButtonView2(modifier: Modifier, width: Dp, height: Dp, text: String) {
    Box(
        modifier
            .size(width, height)
            .clip(RoundedCornerShape(9.dp))
            .background(
                brush = Brush.linearGradient(ChildGradiant)
            )
        ,
        contentAlignment = Alignment.Center) {

        Text(text = text,
            color = TextColor,
            fontSize = 12.sp,
            fontFamily = fontFamily(R.font.poppins_regular)
        )
    }
}

@Composable
fun ToolbarView(title: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, top = 57.dp, end = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .size(46.dp)
                .clip(RoundedCornerShape(17.dp))
                .border(width = 1.dp, TextColor.copy((0.08f)), RoundedCornerShape(17.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "Arrow back"
            )
        }

        Text(
            text = title,
            Modifier.fillMaxWidth(),
            color = TextColor,
            fontSize = 28.sp,
            fontFamily = fontFamily(R.font.merriweather_regular),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CardView(modifier: Modifier, height: Dp, content: @Composable () -> Unit) {
    Card(
        modifier
            .size(width = 335.dp, height = height)
            .shadow(3.dp, shape = RoundedCornerShape(24.dp))
            ,
        shape = RoundedCornerShape(24.dp),
        backgroundColor = Color.White
    ) {
        content()
    }
}

@Composable
fun TextView(text: String) {
    Text(text = text,
        Modifier.padding(start = 15.dp, top = 21.dp),
        color = TextColor6,
        fontSize = 22.sp,
        fontFamily = fontFamily(R.font.merriweather_regular)
    )
}

fun fontFamily(font: Int) = FontFamily(Font(font))