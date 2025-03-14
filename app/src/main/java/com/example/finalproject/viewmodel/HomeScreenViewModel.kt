package com.example.finalproject.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.model.Movie
import com.example.finalproject.model.PopularMoviesApi
import com.example.finalproject.model.Response
import kotlinx.coroutines.launch

sealed interface PopularMoviesUiState {
    data class Success(val popularMovies: Response): PopularMoviesUiState
    object Loading: PopularMoviesUiState
    object Error: PopularMoviesUiState
}

class HomeScreenViewModel: ViewModel() {
    var popularMoviesUiState: PopularMoviesUiState by mutableStateOf<PopularMoviesUiState>(PopularMoviesUiState.Loading)

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            var popularMoviesApi: PopularMoviesApi? = null
            try {
                popularMoviesApi = PopularMoviesApi.getInstance()
                popularMoviesUiState = PopularMoviesUiState.Success(popularMoviesApi.getPopularMovies())
            } catch (e: Exception) {
                popularMoviesUiState = PopularMoviesUiState.Error
            }
        }
    }
}