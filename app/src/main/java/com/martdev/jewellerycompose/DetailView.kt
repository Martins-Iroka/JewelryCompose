package com.martdev.jewellerycompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.martdev.jewellerycompose.ui.theme.*

data class ItemData(
    val image: Int,
    val text: String
)

private val items = listOf(
    ItemData(R.drawable.ic_diamond, "Pink"),
    ItemData(R.drawable.ic_wallet, "$600"),
    ItemData(R.drawable.ic_ticket, "20%"),
    ItemData(R.drawable.ic_flag, "0.14 CT")
)

@Composable
fun JewelryDetailView() {
    val startPad = 45.dp
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(392.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.toolbar_image),
                contentDescription = "Image",
                Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Box(
                Modifier
                    .size(46.dp)
                    .offset(x = 24.dp, y = 34.dp)
                    .clip(RoundedCornerShape(17.dp))
                    .background(Color.White.copy(0.13f))
                    ,
                contentAlignment = Alignment.Center) {
                Icon(painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "Arrow back")
            }
        }


        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = startPad, end = 41.dp)
                .offset(y = (-30).dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Pink Diamond",
                color = TextColor4,
                fontSize = 28.sp,
                fontFamily = fontFamily(R.font.merriweather_bold)
            )

            Box(
                Modifier
                    .size(66.dp, 33.dp)
                    .clip(CircleShape)
                    .background(
                        brush = Brush.linearGradient(ChildGradiant)
                    )
                ,
                contentAlignment = Alignment.Center) {

                Text(text = "20% off",
                    color = TextColor,
                    fontSize = 12.sp,
                    fontFamily = fontFamily(R.font.poppins_regular)
                )
            }
        }
        
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            for (i in items) {
                Item(i.image, i.text)
            }
        }

        Text(text = "About",
            Modifier.padding(start = startPad, top = 18.dp),
            color = TextColor,
            fontSize = 18.sp,
            fontFamily = fontFamily(R.font.merriweather_bold)
        )
        
        Text(text = stringResource(id = R.string.info),
            Modifier.padding(45.dp, top = 5.dp, end = 24.dp),
            color = TextColor3,
            fontSize = 14.sp,
            fontFamily = fontFamily(R.font.poppins_regular),
            textAlign = TextAlign.Justify
        )

        Spacer(modifier = Modifier.padding(top = 27.dp))

        ButtonView(modifier = Modifier.align(Alignment.CenterHorizontally), text = "Add to Cart")

        Spacer(modifier = Modifier.padding(bottom = 18.dp))
    }
}

@Composable
fun Item(image: Int, text: String) {
    Column(
        Modifier
            .size(width = 58.dp, 87.dp)
            .shadow(1.dp, shape = CircleShape)
            .clip(CircleShape)
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = image),
            contentDescription = "", Modifier.size(44.dp))

        Text(text = text,
            color = TextColor,
            fontSize = 12.sp,
            fontFamily = fontFamily(R.font.poppins_regular)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    JewelryDetailView()
}