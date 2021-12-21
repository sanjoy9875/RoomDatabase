package com.example.roomdatabase.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PassingData()
        }
    }
}

@Composable
fun PassingData(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "FirstPage",
        builder = {
            composable("FirstPage", content = {
                FirstPage(navController = navController)
            })
            composable("SecondPage", content = {
                SecondPage(navController = navController)
            })
        }
    )
}

@Composable
fun FirstPage(navController: NavController) {

    val input = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Surface(
            modifier = Modifier.fillMaxWidth(),
            elevation = 8.dp
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        val message = input.value
                        if (message!= ""){
                            navController.navigate("FirstPage")
                        }
                    }
            ) {
                OutlinedTextField(
                    value = input.value,
                    onValueChange = {
                        input.value = it
                    },
                    label = {
                        Text(text = "search one")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),

                    leadingIcon = {
                        Icon(Icons.Filled.Search,"")
                    },

                )

            }
        }
    }
}


@Composable
fun SecondPage(navController: NavController) {

    val input = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Surface(
            modifier = Modifier.fillMaxWidth(),
            elevation = 8.dp
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {

                    }
            ) {
                OutlinedTextField(
                    value = input.value,
                    onValueChange = {
                        input.value = it
                    },
                    label = {
                        Text(text = "search two")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),

                    leadingIcon = {
                        Icon(Icons.Filled.Search,"")
                    },

                    )

            }
        }
    }
}