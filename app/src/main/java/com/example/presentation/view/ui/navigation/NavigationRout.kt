package com.example.presentation.view.ui.navigation

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.data.datasource.entites.Client
import com.example.data.datasource.entites.Invoice
import com.example.data.datasource.entites.Item
import com.example.presentation.view.ui.clientpage.ClientList
import com.example.presentation.view.ui.clientpage.ClientScreen
import com.example.presentation.view.ui.homepage.HomeScreen
import com.example.presentation.view.ui.itempage.ItemList
import com.example.presentation.view.ui.itempage.ItemScreen
import com.example.presentation.view.ui.util.ScreenRoute

@Composable
fun NavigationRout(
    context: Context,
    clientList: List<Client>,
    addClient: (Client) -> Unit,
    invoiceList: List<Invoice>,
    addItem: (Item) -> Unit,
    searchText: String,
    search: (String) -> Unit,
    itemList: List<Item>
) {
    val navigation = rememberNavController()
    NavHost(navController = navigation, startDestination = ScreenRoute.HomeScreen.route) {

        composable("Home") {
            HomeScreen(invoiceList, searchText, search, navigation)
        }
        composable(ScreenRoute.ClientScreen.route) {
            ClientScreen(context, addClient, navigation)
        }
        composable(ScreenRoute.ClientListScreen.route) {
            ClientList(clientList, searchText, search, navigation)
        }
        composable(ScreenRoute.ItemScreen.route) {
            ItemScreen(context = context, addItem = addItem, nav = navigation)
        }
        composable(ScreenRoute.ItemListScreen.route) {
            ItemList(itemList, searchText, search, navigation)
        }

    }
}

@Composable
fun Navigation(nav: NavController) {
    NavigationBar(
    ) {
        NavigationBarItem(selected = false,
            onClick = { nav.navigate(ScreenRoute.HomeScreen.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = { Text(text = "Home Page")},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.onPrimary
            ),
        )
        NavigationBarItem(selected = false,
            onClick = { nav.navigate(ScreenRoute.ClientScreen.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },
            label = { Text(text = "Client")},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.onPrimary
            ),
        )
        NavigationBarItem(selected = false,
            onClick = { nav.navigate(ScreenRoute.ItemListScreen.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null
                )
            },
            label = { Text(text = "Setting")},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.onPrimary
            ),
        )
    }

}