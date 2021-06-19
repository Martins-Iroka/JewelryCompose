package com.martdev.jewellerycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.martdev.jewellerycompose.ui.theme.JewelleryComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JewelleryComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    JewelryApp()
                }
            }
        }
    }
}

enum class Route {
    OnBoarding,
    Home,
    DetailView,
    Cart,
    Checkout,
    Profile
}

@Composable
fun JewelryApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.OnBoarding.name) {
        composable(Route.OnBoarding.name) {
            OnBoarding {
                navController.navigate(Route.Home.name)
            }
        }

        composable(Route.Home.name) {
            HomeView(itemClicked = { navController.navigate(Route.DetailView.name) },
                onProfileClicked = { navController.navigate(Route.Profile.name) }
            ) { navController.navigate(Route.Cart.name) }
        }

        composable(Route.DetailView.name) {
            JewelryDetailView(navigateUpClicked = { navController.navigateUp() }) {
                navController.navigate(Route.Cart.name)
            }
        }

        composable(Route.Cart.name) {
            MyCartView(navigateUpClicked = { navController.navigateUp() }) {
                navController.navigate(Route.Checkout.name)
            }
        }

        composable(Route.Checkout.name) {
            CheckoutView(navigateUp = { navController.navigateUp() }) {
                navController.navigate(Route.Home.name) {
                    popUpTo(Route.Checkout.name) { inclusive = true }
                }
            }
        }

        composable(Route.Profile.name) {
            ProfileView { navController.navigateUp() }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JewelleryComposeTheme {

    }
}