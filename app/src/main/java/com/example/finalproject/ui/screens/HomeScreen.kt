package com.example.finalproject.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.finalproject.R
import com.example.finalproject.ui.screens.HomeScreenComponents.HomeScreenBody
import com.example.finalproject.ui.screens.HomeScreenComponents.SearchField
import com.example.finalproject.viewmodel.HomeScreenViewModel
import com.example.finalproject.viewmodel.MovieDetailsViewModel
import com.example.finalproject.viewmodel.PopularMoviesUiState

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeScreenViewModel: HomeScreenViewModel = viewModel(),
    navController: NavController,
) {
    val uiState = homeScreenViewModel.popularMoviesUiState

    when (uiState) {
        is PopularMoviesUiState.Error -> Text(
            text = stringResource(R.string.error),
            modifier = modifier
        )
        is PopularMoviesUiState.Loading -> Text(
            text = stringResource(R.string.loading),
            modifier = modifier
        )
        is PopularMoviesUiState.Success -> HomeScreenBody(
            modifier = modifier,
            navController = navController,
            uiState.popularMovies.results
        )
    }
}