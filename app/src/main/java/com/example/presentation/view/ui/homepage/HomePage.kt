package com.example.presentation.view.ui.homepage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.data.datasource.entites.Invoice
import com.example.presentation.view.ui.clientpage.TopBar
import com.example.presentation.view.ui.navigation.Navigation
import com.example.presentation.view.ui.util.ScreenRoute
import com.example.quickbill.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    invoice: List<Invoice>,
    search: String,
    searchName: (String) -> Unit,
    nav: NavController
) {
    Scaffold(
        bottomBar = { Navigation(nav) },
        topBar = { TopBar("Quick Bill") },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    nav.navigate(ScreenRoute.ItemListScreen.route)
                },
                containerColor = MaterialTheme.colorScheme.tertiary
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.add_icon),
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
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextField(

                        value = search,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = MaterialTheme.colorScheme.tertiary,
                            textColor = MaterialTheme.colorScheme.onPrimary,
                            cursorColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        placeholder = {
                            Text(text = "Search", color = MaterialTheme.colorScheme.onPrimary)
                        },
                        onValueChange = { client -> searchName(client) })
                    Icon(
                        painter = painterResource(id = R.drawable.search_icon),
                        modifier = Modifier.align(Alignment.CenterVertically),
                        contentDescription = "Search Icon"
                    )
                }
            }
            LazyColumn(verticalArrangement = Arrangement.SpaceBetween) {
                items(invoice) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .clickable {

                        })
                    {
                        Column(
                            verticalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.padding(start = 15.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 5.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = getAnnotatedString(
                                        search,
                                        it,
                                        SpanStyle(MaterialTheme.colorScheme.primary)
                                    ),
                                    modifier = Modifier.padding(end = 15.dp, start = 15.dp),
                                    fontWeight = FontWeight.ExtraBold,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Icon(
                                    painter = painterResource(id = R.drawable.arrow_right),
                                    contentDescription = "Add"
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 5.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {

                                Text(
                                    text = "Due",
                                    modifier = Modifier.padding(end = 15.dp, start = 15.dp),
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                )
                                Text(
                                    text = buildAnnotatedString {
                                        append("$")
                                        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                                            append(it.totalPrice.toString())
                                        }
                                    },
                                    modifier = Modifier.padding(end = 15.dp),
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Spacer(modifier = Modifier.heightIn(10.dp))
                            Divider(
                                color = MaterialTheme.colorScheme.primary,
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