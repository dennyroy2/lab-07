package com.example.lab_7

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.platform.testTag
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.TextField
import androidx.compose.foundation.lazy.items
@Composable
fun DriversScreen(navController: NavController) {
    var driver by remember {
        mutableStateOf("")
    }

    var drivers = remember {
        mutableStateListOf<String>()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // back button
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("backButton") // for testing
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // title text
        Text(
            text = "FormulaZero Drivers",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // text field and button to add race locations
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = driver,
                onValueChange = {
                    driver = it // update location to new value
                },
                label = {
                    Text("Add driver")
                },
                modifier = Modifier.testTag("driverInput") // for testing
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                onClick = {
                    if (driver.isNotBlank()) {
                        drivers.add(driver)
                        driver = ""
                    }
                },
                modifier = Modifier.testTag("addDriverButton") // for testing
            ) {
                Text("Add")
            }

            Button(
                onClick = { drivers.clear() },
                modifier = Modifier.testTag("clearDriversButton")
            ) {
                Text("Clear")
            }
        }

        // list to display races
        LazyColumn {
            items(drivers) { drivee ->
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = drivee,
                    fontSize = 24.sp
                )
            }
        }
    }
}