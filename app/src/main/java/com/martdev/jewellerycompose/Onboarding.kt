package com.martdev.jewellerycompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.martdev.jewellerycompose.ui.theme.GRADIANT
import com.martdev.jewellerycompose.ui.theme.TextColor
import com.martdev.jewellerycompose.ui.theme.TextColor3

@Composable
fun OnBoarding() {

    Column(
        Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(GRADIANT)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painter = painterResource(id = R.drawable.jewelry),
            contentDescription = "Jewelry",
            Modifier.size(381.dp, 406.dp)
        )

        Box(
           contentAlignment = Alignment.TopCenter
        ) {
            Image(painter = painterResource(id = R.drawable.ic_union),
                contentDescription = "Union",
                Modifier
                    .size(width = 355.dp, height = 282.dp)
                    .alpha(0.3f)
            )
            
            Text(text = "The best jewellery in The Town Now!",
                Modifier
                    .width(295.dp)
                    .offset(y = 70.dp),
                color = TextColor,
                fontSize = 28.sp,
                fontFamily = fontFamily(R.font.merriweather_bold),
                textAlign = TextAlign.Center
            )

            Text(text = "We Use 100% pure Metals",
                Modifier.offset(y = 150.dp),
                color = TextColor3,
                fontSize = 14.sp,
                fontFamily = fontFamily(R.font.poppins_regular),
                textAlign = TextAlign.Center
            )

            Image(painter = painterResource(id = R.drawable.ic_fab),
                contentDescription = "FAB",
                Modifier.offset(y = 180.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun OnBoardingPreview() {
    OnBoarding()
}