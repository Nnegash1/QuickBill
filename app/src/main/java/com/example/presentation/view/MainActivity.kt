package com.example.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.other.SortType
import com.example.presentation.view.ui.theme.QuickBillTheme
import com.example.presentation.viewmodel.ContactViewModel
import com.example.presentation.viewmodel.InvoiceViewModelFactory
import com.example.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var factory: InvoiceViewModelFactory
    private val mainViewModel by viewModels<MainViewModel> { factory }
    private val contactViewModel by viewModels<ContactViewModel> { factory }

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

                    val result = contactViewModel.client.collectAsState(listOf())
                    val defaultSearch = contactViewModel.searchText.collectAsState().value

                    Column {
                        TextField(value = defaultSearch, onValueChange = contactViewModel::onSearch)
                        Button(onClick = { mainViewModel.sortInvoice(SortType.NAME) }) {
                            Text(text = "Update")
                        }
                        LazyColumn() {
                            items(result.value) {
                                Text(text = it.name)
                            }
                        }
                    }
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