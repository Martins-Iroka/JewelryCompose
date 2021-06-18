package com.martdev.jewellerycompose

import androidx.annotation.FontRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.martdev.jewellerycompose.ui.theme.*

@Composable
fun MyCartView() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {

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
                Icon(painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "Arrow back")
            }
            
            Text(text = "My Cart",
                Modifier.fillMaxWidth(),
                color = TextColor,
                fontSize = 28.sp,
                fontFamily = fontFamily(R.font.merriweather_regular),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.padding(top = 40.dp))

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for (i in 1..2) {
                CartItem()
            }

            Column(
                Modifier
                    .size(335.dp, 204.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(24.dp))
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.White)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Payment ",
                    Modifier.padding(start = 15.dp, top = 21.dp),
                    color = TextColor6,
                    fontSize = 22.sp,
                    fontFamily = fontFamily(R.font.merriweather_regular)
                )

                PaymentItem(text = "Item total", text2 = "\$1000", topPadding = 24.dp)

                PaymentItem(text = "Delivery fee", text2 = "\$50")

                Divider(Modifier.fillMaxWidth().padding(start = 15.dp, top = 16.dp, end = 18.dp))

                PaymentItem(text = "Total",
                    text2 = "\$1050", Color.Black,
                    fontFamily = R.font.merriweather_bold)
            }

            ButtonView(modifier = Modifier
                .padding(top = 93.dp, bottom = 16.dp)
                .align(Alignment.CenterHorizontally)
                ,
                text = "Go to Checkout")
        }
    }
}

@Composable
fun PaymentItem(text: String, text2: String,
                color: Color = TextColor5,
                topPadding: Dp = 16.dp,
                @FontRes fontFamily: Int = R.font.merriweather_regular
) {
    Row(
        Modifier.fillMaxWidth().padding(start = 15.dp, top = topPadding, end = 18.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text,
            color = color,
            fontSize = 16.sp,
            fontFamily = fontFamily(fontFamily)
        )

        Text(text = text2,
            color = color,
            fontSize = 16.sp,
            fontFamily = fontFamily(fontFamily)
        )
    }
}

@Composable
fun CartItem() {
    Box(
        Modifier
            .size(335.dp, 113.dp)
            .shadow(3.dp, shape = RoundedCornerShape(24.dp))
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White)
    ) {

        Box(
            Modifier
                .size(66.dp, 33.dp)
                .offset(x = 255.dp, y = 70.dp)
                .clip(RoundedCornerShape(9.dp))
                .background(
                    brush = Brush.linearGradient(ChildGradiant)
                )
            ,
            contentAlignment = Alignment.Center) {

            Text(text = "\$600",
                color = TextColor,
                fontSize = 12.sp,
                fontFamily = fontFamily(R.font.poppins_regular)
            )
        }

        Row(
            Modifier.padding(start = 15.dp, top = 21.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.jewelry_),
                contentDescription = "Jewelry", Modifier.size(72.dp))

            Column {
                Text(text = "Pink Diamond",
                    color = TextColor4,
                    fontSize = 18.sp,
                    fontFamily = fontFamily(R.font.merriweather_bold)
                )
                
                Text(text = "Round Cut Cubic Zircon Stones.",
                    color = TextColor3,
                    fontSize = 12.sp,
                    fontFamily = fontFamily(R.font.poppins_regular)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(id = R.drawable.ic_minus), contentDescription = "Minus")

                    Text(text = "1",
                        color = TextColor5,
                        fontSize = 12.sp,
                        fontFamily = fontFamily(R.font.poppins_regular)
                    )

                    Image(painter = painterResource(id = R.drawable.ic_add), contentDescription = "Minus")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyCardPreview() {
    MyCartView()
}