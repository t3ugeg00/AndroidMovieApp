package com.example.finalproject.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "main"
    ){
        composable(
            route = "main"
        ){
            MovieApp(
                navController = navController
            )
        }
        composable(
            route = "details/{id}"
        ){ query ->
            val id = query.arguments?.getString("id") ?: ""
            DetailsScreen(
                navController = navController,
                id = id
            )
        }
    }
}