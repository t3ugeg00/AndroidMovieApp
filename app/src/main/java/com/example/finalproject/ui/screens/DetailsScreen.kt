package com.example.finalproject.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.finalproject.R
import com.example.finalproject.ui.screens.DetailsScreenComponents.DetailsScreenBody
import com.example.finalproject.ui.screens.DetailsScreenComponents.DetailsTopBar
import com.example.finalproject.viewmodel.MovieDetailsUiState
import com.example.finalproject.viewmodel.MovieDetailsViewModel

@Composable
fun DetailsScreen(
    id: String,
    navController: NavController,
    movieDetailsViewModel: MovieDetailsViewModel = viewModel()
) {
    val uiState = movieDetailsViewModel.movieDetailsUiState

    LaunchedEffect(
        key1 = id
    ) {
        movieDetailsViewModel.getDetails(id)
    }

    Scaffold(
        topBar = { DetailsTopBar(navController, stringResource(R.string.app_name)) }
    ) { innerPadding ->
        when (uiState) {
            is MovieDetailsUiState.Loading -> Text(
                text = stringResource(R.string.loading),
                modifier = Modifier.padding(innerPadding)
            )
            is MovieDetailsUiState.Success -> DetailsScreenBody(modifier = Modifier.padding(innerPadding), movie = uiState.movie)
            is MovieDetailsUiState.Error -> Text(
                text = stringResource(R.string.error),
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}