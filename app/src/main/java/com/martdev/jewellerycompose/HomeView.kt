package com.martdev.jewellerycompose

import androidx.compose.foundation.*
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.martdev.jewellerycompose.ui.theme.*

@Composable
fun HomeView() {
    val radius = 40.dp
    val startDp = 34.dp

    Scaffold(
        Modifier
            .fillMaxSize()
        ,
        bottomBar = {
            BottomAppBar(
                Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .clip(RoundedCornerShape(topStart = radius, topEnd = radius)),
                backgroundColor = Color.White,
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(208.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_heart),
                        contentDescription = "Heart",
                    )

                    Icon(painter = painterResource(id = R.drawable.ic_user),
                        contentDescription = "Person")
                }
            }
        },
        floatingActionButton = {
            Image(painter = painterResource(id = R.drawable.ic_fab2),
                contentDescription = "Fab",
                Modifier.offset(y = 45.dp)
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {

        Box(
            Modifier
                .fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.ic_background),
                contentDescription = "B", Modifier.fillMaxSize())

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(it)
                    .verticalScroll(rememberScrollState())
            ) {

                Toolbar()

                Text(text = "Best jewellery\nfor you",
                    Modifier.padding(start = startDp, top = 49.dp),
                    color = TextColor,
                    fontSize = 34.sp,
                    fontFamily = fontFamily(R.font.merriweather_bold)
                )

                Spacer(Modifier.padding(top = 16.dp))

                Row(
                    Modifier
                        .size(314.dp, 60.dp)
                        .shadow(1.dp, RoundedCornerShape(18))
                        .clip(RoundedCornerShape(18))
                        .background(Color.White)
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Spacer(Modifier.padding(start = 16.dp))

                    Icon(painter = painterResource(id = R.drawable.ic_search_24),
                        contentDescription = "Search",
                        Modifier
                            .size(18.dp)
                    )

                    Text(text = "Search",
                        color = TextColor2,
                        fontSize = 17.sp,
                        fontFamily = fontFamily(R.font.sf_semibold)
                    )
                }

                TabRow()
                
                LazyRow(contentPadding = PaddingValues(horizontal = 43.dp, vertical = 18.dp),
                    horizontalArrangement = Arrangement.spacedBy(26.dp)
                ) {
                    items(5, key = {it}) {
                        JewelryItemView()
                    }
                }
            }
        }
    }
}

@Composable
private fun Toolbar() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 38.dp, top = 43.dp, end = 38.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_hamb),
            contentDescription = "Ham"
        )

        Icon(painter = painterResource(id = R.drawable.ic_cart), contentDescription = "Cart")
    }
}

@Composable
private fun TabRow() {
    var selected by remember { mutableStateOf(0) }

    ScrollableTabRow(selectedTabIndex = selected,
        modifier = Modifier
            .padding(top = 18.dp),
        backgroundColor = Color.Transparent,
        contentColor = Color.Transparent,
        indicator = {
            TabRowDefaults.Indicator(color = Color.Transparent)
        },
        divider = {
            TabRowDefaults.Divider(color = Color.Transparent)
        }
    ) {
        TabItem(text = "All", selected = selected == 0) { selected = 0 }

        TabItem(text = "Gold", selected = selected == 1) { selected = 1 }

        TabItem(text = "Diamond", selected = selected == 2) { selected = 2 }

        TabItem(text = "Silver", selected = selected == 3) { selected = 3 }

        TabItem(text = "Steel", selected = selected == 4) { selected = 4 }
    }
}

@Composable
fun TabItem(text: String,
            selected: Boolean,
            color: Color = TextColor,
            clicked: () -> Unit) {


    Tab(selected = selected, onClick = clicked) {
        Box(
            Modifier
                .clip(CircleShape)
                .background(
                    brush = if (selected) Brush.linearGradient(ChildGradiant2)
                    else Brush.linearGradient(listOf(Color.Transparent, Color.Transparent))
                )
        ) {
            Text(text = text,
                Modifier.padding(horizontal = 20.dp, vertical = 6.dp),
                color = color,
                fontSize = 14.sp,
                fontFamily = fontFamily(R.font.merriweather_regular)
            )

        }
    }
}

@Composable
fun JewelryItemView() {
    Box(
        Modifier
            .clip(RoundedCornerShape(32.dp))
            .background(Color.White)
    ) {
        Column(
            Modifier.padding(start = 19.dp, top = 29.dp, end = 19.dp, bottom = 17.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.jewelry3),
                contentDescription = "Jewelry",
                Modifier.size(197.dp, 147.dp)
            )
            
            Text(text = "Diamond Ring",
                Modifier.padding(top = 25.dp),
                color = Color.Black,
                fontSize = 22.sp,
                fontFamily = fontFamily(R.font.merriweather_bold)
            )

            Text(text = "Pure ring with Diamonds (0.1400 Ct)",
                Modifier
                    .padding(top = 10.dp)
                    .width(170.dp),
                color = TextColor3,
                fontSize = 14.sp,
                fontFamily = fontFamily(R.font.poppins_regular),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.padding(top = 20.dp))
            Box(
                Modifier
                    .size(width = 153.dp, 43.dp)
                    .clip(RoundedCornerShape(9.dp))
                    .background(
                        brush = Brush.linearGradient(ChildGradiant2)
                    ),
            contentAlignment = Alignment.Center) {
                Text(text = "\$600",
                    color = TextColor,
                    fontSize = 18.sp,
                    fontFamily = fontFamily(R.font.merriweather_bold)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeView()
}