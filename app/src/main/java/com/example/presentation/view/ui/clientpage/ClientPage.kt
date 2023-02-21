package com.example.presentation.view.ui.clientpage

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.data.datasource.entites.Client
import com.example.presentation.view.ui.util.ScreenRoute
import com.example.quickbill.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientScreen(context: Context, addInvoice: (Client) -> Unit, nav: NavController) {
    val name = rememberSaveable { mutableStateOf("") }
    val email = rememberSaveable { mutableStateOf("") }
    val phoneNumber = rememberSaveable { mutableStateOf("") }
    val country = rememberSaveable { mutableStateOf("") }
    val postCode = rememberSaveable { mutableStateOf("") }
    val state = rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            "Client",
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onPrimary,
                            textAlign = TextAlign.Center,
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.close_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(10.dp)
                                .clickable {
                                    Toast
                                        .makeText(
                                            context,
                                            "Client Button Not implemented",
                                            Toast.LENGTH_LONG
                                        )
                                        .show()
                                },
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .background(MaterialTheme.colorScheme.onPrimary)
                .fillMaxSize()
        ) {
            Text(
                text = "Contact Details",
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.heightIn(5.dp))
            CustomCard(
                placeHolder = "Full Name",
                title = name.value,
                modifier = Modifier.fillMaxWidth(),
                change = { clientName ->
                    name.value = clientName
                })
            CustomCard(
                placeHolder = "Mobile Number",
                modifier = Modifier.fillMaxWidth(),
                type = KeyboardType.Number,
                title = phoneNumber.value,
                change = { clientName -> phoneNumber.value = clientName }
            )
            CustomCard(
                placeHolder = "Email",
                type = KeyboardType.Email,
                title = email.value,
                modifier = Modifier.fillMaxWidth(),
                change = { clientEmail ->
                    email.value = clientEmail
                }
            )
            Text(
                text = "Address",
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(10.dp)
            )
            CustomCard(
                placeHolder = "Address",
                type = KeyboardType.Email,
                title = country.value,
                modifier = Modifier.fillMaxWidth(),
                change = { address ->
                    country.value = address
                }
            )
            Row(horizontalArrangement = Arrangement.SpaceAround) {
                CustomCard(
                    placeHolder = "Post Code",
                    type = KeyboardType.Number,
                    title = postCode.value,
                    change = { _postCode ->
                        postCode.value = _postCode
                    }
                )
                CustomCard(
                    placeHolder = "State",
                    title = state.value,
                    change = { _state ->
                        state.value = _state
                    }
                )
            }
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .heightIn(50.dp)
                    .padding(15.dp)
                    .border(1.dp, Color.Gray, shape = ShapeDefaults.Small),
                onClick = {
                    try {
                        if (name.value.isNotBlank()) {
                            addInvoice(
                                Client(
                                    name = name.value,
                                    phoneNumber = phoneNumber.value,
                                    email = email.value,
                                    country = country.value,
                                    postCode = postCode.value,
                                    state = state.value
                                )
                            )
                            nav.navigate(ScreenRoute.HomeScreen.route)
                        } else {
                            Toast.makeText(
                                context,
                                "Please Fill out the client name",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    } catch (m: Exception) {
                        Log.d("TAG", "Error when adding client to DB: ${m.stackTrace}")
                    }

                }, colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Save",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomCard(
    title: String,
    change: (String) -> Unit,
    placeHolder: String,
    modifier: Modifier = Modifier,
    type: KeyboardType = KeyboardType.Text
) {
    Card(
        shape = ShapeDefaults.Medium,
        colors = CardDefaults.cardColors(),
        modifier = modifier.padding(5.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
    ) {
        TextField(
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colorScheme.primary,
                containerColor = MaterialTheme.colorScheme.onPrimary
            ),
            value = title, onValueChange = { change(it) }, modifier = modifier,
            keyboardOptions = KeyboardOptions(keyboardType = type),
            placeholder = {
                Text(text = placeHolder)
            }
        )
    }
}