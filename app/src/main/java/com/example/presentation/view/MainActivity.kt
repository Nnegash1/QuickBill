package com.example.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.view.ui.navigation.NavigationRout
import com.example.presentation.view.ui.theme.QuickBillTheme
import com.example.presentation.viewmodel.ContactViewModel
import com.example.presentation.viewmodel.InvoiceViewModelFactory
import com.example.presentation.viewmodel.ItemViewModel
import com.example.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var factory: InvoiceViewModelFactory
    private val main: MainViewModel by viewModels { factory }
    private val itemVm: ItemViewModel by viewModels { factory }
    private val clientViewModel: ContactViewModel by viewModels { factory }

    @OptIn(ExperimentalMaterial3Api::class)
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
                    val search = clientViewModel.searchText.collectAsState().value
                    val searchTwo = main.searchText.collectAsState().value
                    val client = clientViewModel.client.collectAsState().value
                    val itemList = itemVm.item.collectAsState().value
                    NavigationRout(
                        context = this,
                        clientList = client,
                        addClient = clientViewModel::addClient,
                        invoiceList = result,
                        searchText = search,
                        search = clientViewModel::onSearch,
                        addItem = itemVm::addItemViewModel,
                        itemList = itemList
                    )
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