package com.example.finalproject.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.model.Movie
import com.example.finalproject.model.Response
import com.example.finalproject.model.SearchMoviesApi
import kotlinx.coroutines.launch

sealed interface SearchMoviesUiState {
    data class Success(val movies: Response): SearchMoviesUiState
    object Loading: SearchMoviesUiState
    object Error: SearchMoviesUiState
}

class SearchFieldViewmodel: ViewModel() {
    var value by mutableStateOf("")
    var searchMoviesUiState: SearchMoviesUiState by mutableStateOf<SearchMoviesUiState>(SearchMoviesUiState.Loading)
        private set

    fun getSearchResults() {
        viewModelScope.launch {
            var searchMoviesApi: SearchMoviesApi? = null
            try {
                searchMoviesApi = SearchMoviesApi.getInstance()
                searchMoviesUiState = SearchMoviesUiState.Success(searchMoviesApi.getSearchMovies(value))
            } catch (e: Exception) {
                searchMoviesUiState = SearchMoviesUiState.Error
            }
        }
    }
}