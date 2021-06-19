package com.martdev.jewellerycompose

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.martdev.jewellerycompose.ui.theme.TextColor5
import com.martdev.jewellerycompose.ui.theme.TextColor7
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CheckoutView(
    navigateUp: () -> Unit,
    homeClicked: () -> Unit
) {

    val scope = rememberCoroutineScope()

    var showView by remember {
        mutableStateOf(false)
    }

    var width by remember {
        mutableStateOf(100.dp)
    }

    var height by remember {
        mutableStateOf(100.dp)
    }

    var offset by remember {
        mutableStateOf(500.dp)
    }

    val animOffset by animateDpAsState(targetValue = offset,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    suspend fun launchPopup() {
        delay(500L)
        offset = 20.dp
        delay(1000L)
        width = 300.dp
        height = 150.dp
        delay(1000)
        showView = true
    }

    Box(Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CheckoutBody(navigateUp = {navigateUp()}) {
            scope.launch {
                launchPopup()
            }
        }

        Column(
            Modifier
                .size(width, height)
                .offset(y = animOffset)
                .shadow(2.dp, RoundedCornerShape(20))
                .clip(RoundedCornerShape(20))
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(25.dp, Alignment.Top)
        ) {

            if (showView) {
                TextView(text = "Order Placed")

                ButtonView(modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "OK",
                    width = 150.dp, height = 50.dp
                ) { homeClicked() }
            }
        }
    }
}

@Composable
private fun CheckoutBody(
    navigateUp: () -> Unit,
    clicked: () -> Unit) {
    val height = 184.dp

    var alpha by remember {
        mutableStateOf(1f)
    }

    val animAlpha by animateFloatAsState(targetValue = alpha)

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .alpha(animAlpha)
            .verticalScroll(rememberScrollState())
    ) {
        ToolbarView(title = "Checkout") { navigateUp()}

        CardView(
            modifier = Modifier
                .padding(top = 33.dp)
                .align(Alignment.CenterHorizontally), height = height
        ) {
            Column {
                TextView(text = "Deliver to")

                Row(
                    Modifier.padding(start = 15.dp, top = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = "Location"
                    )

                    Text(
                        text = "Imran Road, Khayaban Colony, Lahore, Pakistan7",
                        color = TextColor5,
                        fontSize = 16.sp,
                        fontFamily = fontFamily(R.font.merriweather_regular)
                    )
                }

                ButtonView2(
                    modifier = Modifier
                        .padding(top = 16.dp, end = 20.dp)
                        .align(Alignment.End),
                    width = 120.dp,
                    height = 33.dp,
                    text = "Change Address"
                )
            }
        }

        CardView(
            modifier = Modifier
                .padding(top = 33.dp)
                .align(Alignment.CenterHorizontally), height = height
        ) {

            Column {
                TextView(text = "Payment Method")

                Row(
                    Modifier.padding(start = 15.dp, top = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_wallet2),
                        contentDescription = "Location"
                    )

                    Text(buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = TextColor5,
                                fontSize = 16.sp,
                                fontFamily = fontFamily(R.font.merriweather_regular)
                            )
                        ) {

                            append("**** **** **** 3947\n")
                        }

                        withStyle(
                            style = SpanStyle(
                                color = TextColor7,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Light,
                                fontFamily = fontFamily(R.font.poppins_regular)
                            )
                        ) {
                            append("Visa")
                        }
                    })
                }

                ButtonView2(
                    modifier = Modifier
                        .padding(top = 20.dp, end = 20.dp)
                        .align(Alignment.End),
                    width = 120.dp,
                    height = 33.dp,
                    text = "Use other"
                )
            }
        }

        CardView(
            modifier = Modifier
                .padding(top = 15.dp)
                .align(Alignment.CenterHorizontally), height = 204.dp
        ) {
            Column {
                TextView(text = "Amount")

                PaymentItem(text = "Item total", text2 = "\$1000", topPadding = 24.dp)

                PaymentItem(text = "Delivery fee", text2 = "\$50")

                Divider(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, top = 16.dp, end = 18.dp)
                )

                PaymentItem(
                    text = "Total",
                    text2 = "\$1050", Color.Black,
                    fontFamily = R.font.merriweather_bold
                )
            }
        }


        ButtonView(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 16.dp)
                .align(Alignment.CenterHorizontally),
            text = "Place Order"
        ) {
            alpha = 0.3f
            clicked()
        }
    }
}

@Preview
@Composable
private fun CheckoutPreview() {
    CheckoutView ({}, {})
}