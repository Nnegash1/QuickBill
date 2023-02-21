package com.example.presentation.view.ui.util

sealed class ScreenRoute(val route: String) {
    object HomeScreen : ScreenRoute("Home")
    object ClientScreen : ScreenRoute("Client")
    object ClientListScreen : ScreenRoute("Client List")
    object ItemScreen : ScreenRoute("Item")
    object ItemListScreen : ScreenRoute("Item List")
}
