package com.example.lab_7

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.lab_7.ui.theme.FormulaZeroApp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun FormulaZeroApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("races") { UpcomingRacesScreen(navController)}
        composable ("drivers"){ DriversScreen(navController) }

    }
}