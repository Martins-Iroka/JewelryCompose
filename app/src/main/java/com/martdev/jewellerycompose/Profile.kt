package com.martdev.jewellerycompose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.martdev.jewellerycompose.ui.theme.TextColor
import com.martdev.jewellerycompose.ui.theme.TextColor5
import com.martdev.jewellerycompose.ui.theme.TextColor8

@Composable
fun ProfileView() {

    Box(
        Modifier
            .fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.ic_background),
            contentDescription = "B", Modifier.fillMaxSize())

        Column(
            Modifier.fillMaxSize()
        ) {
            ProfileToolbar()

            Image(painter = painterResource(id = R.drawable.profile_pic),
                contentDescription = "",
                Modifier
                    .size(180.dp)
                    .padding(top = 68.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(color = TextColor,
                    fontSize = 28.sp,
                    fontFamily = fontFamily(R.font.poppins_regular))
                ) {

                    append("Robert Fox\n")
                }

                withStyle(style = SpanStyle(color = TextColor8,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = fontFamily(R.font.poppins_regular)
                )
                ) {
                    append("robertfox@gmail.com")
                }
            },
                Modifier
                    .padding(top = 19.dp)
                    .align(Alignment.CenterHorizontally),

                textAlign = TextAlign.Center
            )

            Item(
                modifier = Modifier
                    .padding(top = 62.dp)
                    .align(Alignment.CenterHorizontally),
                leadingIcon = R.drawable.ic_settings,
                text = "Settings"
            )

            Item(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .align(Alignment.CenterHorizontally),
                leadingIcon = R.drawable.ic_wallet3,
                text = "Payment"
            )

            Item(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .align(Alignment.CenterHorizontally),
                leadingIcon = R.drawable.ic_password,
                text = "Password"
            )
        }
    }

}

@Composable
private fun ProfileToolbar() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, top = 57.dp, end = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        NavButton(R.drawable.ic_arrow_back)

        Text(
            text = "My Profile",
            color = TextColor,
            fontSize = 28.sp,
            fontFamily = fontFamily(R.font.merriweather_regular),
            textAlign = TextAlign.Center
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_menu_dots),
            contentDescription = "Menu"
        )
    }
}

@Composable
private fun NavButton(@DrawableRes icon: Int) {
    Box(
        Modifier
            .size(46.dp)
            .clip(RoundedCornerShape(17.dp))
            .border(width = 1.dp, TextColor.copy((0.08f)), RoundedCornerShape(17.dp)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Arrow back"
        )
    }
}

@Composable
fun Item(modifier: Modifier, @DrawableRes leadingIcon: Int,
         text: String) {

    val radius = 29.dp
    Row(
        modifier
            .size(335.dp, 85.dp)
            .clip(RoundedCornerShape(radius))
            .background(Color.White.copy(0.46f)),

        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = leadingIcon),
            contentDescription = "",
            Modifier.size(64.dp).padding(start = 15.dp)
        )
        
        Spacer(modifier = Modifier.padding(start = 30.dp))

        Text(text = text,
            color = TextColor,
            fontSize = 18.sp,
            fontFamily = fontFamily(R.font.merriweather_regular)
        )

        Spacer(modifier = Modifier.padding(start = 89.dp))

        NavButton(icon = R.drawable.ic_arrow_forward)

        Spacer(modifier = Modifier.padding(start = 17.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProfileView()
}