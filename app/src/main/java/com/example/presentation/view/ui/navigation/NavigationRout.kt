package com.example.presentation.view.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.presentation.view.ui.util.ScreenRoute

@Composable
fun NavigationRout(navController : NavHostController){
    NavHost(navController = navController, startDestination = ScreenRoute.HomeScreen.route){
        composable("Home"){

        }
        composable("Client"){

        }
        composable("Items"){

        }
    }
}