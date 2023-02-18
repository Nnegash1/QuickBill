package com.example.presentation.view.ui.homepage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.datasource.entites.Invoice
import com.example.quickbill.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(invoice: List<Invoice>, search: String, searchName: (name: String) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Quick Bill", color = MaterialTheme.colorScheme.onPrimary) },
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Add"
                )
            }
        },
    ) {
        Column(modifier = Modifier.padding(it)) {
            Card(
                shape = ShapeDefaults.Medium,
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary),
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
            ) {
                TextField(
                    value = search,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        textColor = MaterialTheme.colorScheme.onPrimary,
                        cursorColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { client -> searchName(client) })
            }
            LazyColumn(verticalArrangement = Arrangement.SpaceBetween) {
                items(invoice) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Column(verticalArrangement = Arrangement.SpaceEvenly) {
                            Text(
                                text = getAnnotatedString(
                                    search,
                                    it,
                                    SpanStyle(MaterialTheme.colorScheme.primary)
                                ),
                                modifier = Modifier.padding(end = 15.dp, start = 15.dp),
                                fontWeight = FontWeight.Bold,
                            )
                            Text(

                                text = it.totalPrice.toString(),
                                modifier = Modifier.padding(end = 15.dp, start = 15.dp),
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold,
                            )
                            Spacer(modifier = Modifier.heightIn(15.dp))
                            Divider(
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(5.dp)
                            )
                        }
                    }
                }
            }

        }
    }
}

fun getAnnotatedString(
    searchQuery: String,
    invoice: Invoice,
    highlightStyle: SpanStyle
): AnnotatedString {
    //Find where searchQuery appears in courseName
    val startIndex = invoice.client.name.indexOf(searchQuery, 0, ignoreCase = true)
    val builder = AnnotatedString.Builder(invoice.client.name)
    //If the query is in the name, add a style, otherwise do nothing
    if (startIndex >= 0) {
        val endIndex = startIndex + searchQuery.length
        builder.addStyle(highlightStyle, startIndex, endIndex)
    }
    return builder.toAnnotatedString()
}