package com.martdev.jewellerycompose

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.martdev.jewellerycompose.ui.theme.GRADIANT
import com.martdev.jewellerycompose.ui.theme.TextColor
import com.martdev.jewellerycompose.ui.theme.TextColor3
import kotlinx.coroutines.delay

@Composable
fun OnBoarding(clicked: () -> Unit) {

    var offset by remember {
        mutableStateOf(195.dp)
    }
    var rotate by remember {
        mutableStateOf(0f)
    }

    val offDp by animateDpAsState(targetValue = offset,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    val animRotate by animateFloatAsState(targetValue = rotate,
        animationSpec = tween(
            durationMillis = 500,
            easing = LinearOutSlowInEasing
        )
    )

    suspend fun launchAnim() {
        offset = 170.dp
        delay(500L)
        rotate = 360f
        delay(1000L)
        offset = 195.dp
    }

    LaunchedEffect(Unit) {
        delay(300L)
        launchAnim()
    }

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
                Modifier
                    .offset(y = offDp)
                    .rotate(animRotate)
                    .clickable { clicked() }
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun OnBoardingPreview() {
    OnBoarding {}
}