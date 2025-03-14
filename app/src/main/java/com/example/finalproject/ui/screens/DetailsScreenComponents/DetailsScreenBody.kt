package com.example.finalproject.ui.screens.DetailsScreenComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.finalproject.R
import com.example.finalproject.model.Movie
import com.example.finalproject.viewmodel.MovieDetailsViewModel

@Composable
fun DetailsScreenBody(
    modifier: Modifier = Modifier,
    movie: Movie,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = movie.title,
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w780${movie.poster_path}",
            contentDescription = movie.title
        )
        LazyRow() {
            items(movie.genres) { genre ->
                Text(
                    text = genre.name,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
        Text(
            text = stringResource(R.string.rating, movie.vote_average, movie.vote_count)
        )
        Text(
            text = movie.overview,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
    }
}