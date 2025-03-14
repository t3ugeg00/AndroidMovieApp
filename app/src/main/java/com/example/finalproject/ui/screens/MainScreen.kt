package com.example.finalproject.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.finalproject.ui.screens.HomeScreenComponents.TopBarWithInput
import com.example.finalproject.viewmodel.SearchFieldViewmodel

@Composable
fun MovieApp(modifier: Modifier = Modifier, searchFieldViewmodel: SearchFieldViewmodel = viewModel(), navController: NavController) {
    Scaffold(
        topBar = { TopBarWithInput(navController) }
    ){ innerPadding ->
        if (searchFieldViewmodel.value === "") {
            HomeScreen(
                modifier = Modifier.padding(innerPadding),
                navController = navController
            )
        } else {
            SearchScreen(
                modifier = Modifier.padding(innerPadding),
                navController = navController
            )
        }
    }
}