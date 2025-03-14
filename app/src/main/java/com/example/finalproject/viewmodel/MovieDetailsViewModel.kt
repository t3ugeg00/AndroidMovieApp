package com.example.finalproject.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.model.Movie
import com.example.finalproject.model.MovieDetailsApi
import kotlinx.coroutines.launch

sealed interface MovieDetailsUiState {
    data class Success(val movie: Movie): MovieDetailsUiState
    object Error: MovieDetailsUiState
    object Loading: MovieDetailsUiState
}

class MovieDetailsViewModel : ViewModel() {
    var movieDetailsUiState: MovieDetailsUiState by mutableStateOf<MovieDetailsUiState>(MovieDetailsUiState.Loading)

    fun getDetails(id: String) {
        viewModelScope.launch {
            var movieDetailsApi: MovieDetailsApi? = null
            try {
                movieDetailsApi = MovieDetailsApi.getInstance()
                movieDetailsUiState = MovieDetailsUiState.Success(movieDetailsApi.getMovieDetails(id))
            } catch (e: Exception) {
                movieDetailsUiState = MovieDetailsUiState.Error
            }
        }
    }
}