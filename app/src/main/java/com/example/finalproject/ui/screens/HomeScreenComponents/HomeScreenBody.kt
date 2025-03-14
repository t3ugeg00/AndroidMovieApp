package com.example.finalproject.ui.screens.HomeScreenComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.finalproject.R
import com.example.finalproject.model.Movie

@Composable
fun HomeScreenBody(
    modifier: Modifier,
    navController: NavController,
    movies: List<Movie>
) {
    Column(
        modifier = modifier.padding(8.dp).fillMaxWidth()
    ){
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(movies) { movie ->
                if (movie.poster_path !== null) {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w780${movie.poster_path}",
                        contentDescription = movie.title,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = movie.title,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Button(
                        onClick = {
                            navController.navigate("details/${movie.id}")
                        },
                    ){
                        Text(
                            text = stringResource(R.string.read_more),
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                    HorizontalDivider(
                        thickness = 2.dp
                    )
                }
            }
        }
    }
}