package com.martdev.jewellerycompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun CheckoutView() {
    val height = 184.dp
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        ToolbarView(title = "Checkout")
        
        CardView(modifier = Modifier
            .padding(top = 33.dp)
            .align(Alignment.CenterHorizontally), height = height) {
            Column {
                TextView(text = "Deliver to")
                
                Row(
                    Modifier.padding(start = 15.dp, top = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = "Location")

                    Text(text = "Imran Road, Khayaban Colony, Lahore, Pakistan7",
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

        CardView(modifier = Modifier
            .padding(top = 33.dp)
            .align(Alignment.CenterHorizontally), height = height) {

            Column {
                TextView(text = "Payment Method")

                Row(
                    Modifier.padding(start = 15.dp, top = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(id = R.drawable.ic_wallet2),
                        contentDescription = "Location")

                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(color = TextColor5,
                            fontSize = 16.sp,
                            fontFamily = fontFamily(R.font.merriweather_regular))) {

                            append("**** **** **** 3947\n")
                        }

                        withStyle(style = SpanStyle(color = TextColor7,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Light,
                            fontFamily = fontFamily(R.font.poppins_regular)
                        )) {
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

        CardView(modifier = Modifier
            .padding(top = 15.dp)
            .align(Alignment.CenterHorizontally), height = 204.dp) {
            Column {
                TextView(text = "Amount")

                PaymentItem(text = "Item total", text2 = "\$1000", topPadding = 24.dp)

                PaymentItem(text = "Delivery fee", text2 = "\$50")

                Divider(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, top = 16.dp, end = 18.dp))

                PaymentItem(text = "Total",
                    text2 = "\$1050", Color.Black,
                    fontFamily = R.font.merriweather_bold)
            }
        }


        ButtonView(modifier = Modifier
            .padding(top = 20.dp, bottom = 16.dp)
            .align(Alignment.CenterHorizontally)
            ,
            text = "Place Order")
    }
}

@Preview
@Composable
private fun CheckoutPreview() {
    CheckoutView()
}