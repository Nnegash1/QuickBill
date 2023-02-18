package com.example.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.data.datasource.entites.Client
import com.example.data.datasource.entites.Invoice
import com.example.data.datasource.entites.Item
import com.example.presentation.view.ui.homepage.HomeScreen
import com.example.presentation.view.ui.theme.QuickBillTheme
import com.example.presentation.viewmodel.InvoiceViewModelFactory
import com.example.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var factory: InvoiceViewModelFactory
    val main: MainViewModel by viewModels { factory }
    val invoice = Invoice(
        invoiceNumber = Random().nextLong().toString(),
        issueDate = Date(),
        item = listOf(
            Item(
                description = "1200R20 668 22PR",
                brand = "TRIANGLE",
                origin = "CHINA",
                hsCode = "40111000",
                item = "TIRE",
                qty = 12,
                unitPrice = 12.0,
                fobPrice = 12.0,
            )
        ),
        client = Client(
            "Kifle",
            phoneNumber = "000-000-0000",
            email = "nahom@gmail.com",
            country = "Ethiopia",
            street = "Addis Ababa",
            apt = "123",
            postCode = "20866",
            city = "",
            province = ""
        ),
        totalPrice = 12.0
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuickBillTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val result = main.invoice.collectAsState().value
                    val search = main.searchText.collectAsState().value
                    HomeScreen(result,search, main::onSearch)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuickBillTheme {
    }
}