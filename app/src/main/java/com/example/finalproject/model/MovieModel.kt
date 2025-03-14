package com.example.finalproject.model

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

data class Response (
    val page: Int,
    val results: List<Movie>
)

data class Movie (
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String?,
    val release_date: String,
    val vote_average: Float,
    val vote_count: Int,
    val genres: List<Genre>
)

data class Genre (
    val id: Int,
    val name: String
)

const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = ""

interface PopularMoviesApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") api_key: String = API_KEY
    ) : Response

    companion object {
        var movieService: PopularMoviesApi? = null

        fun getInstance(): PopularMoviesApi {
            if (movieService === null) {
                movieService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(PopularMoviesApi::class.java)
            }

            return movieService!!
        }
    }
}

interface SearchMoviesApi {
    @GET("search/movie")
    suspend fun getSearchMovies(
        @Query("query") query: String,
        @Query("api_key") api_key: String = API_KEY
    ) : Response

    companion object {
        var movieService: SearchMoviesApi? = null

        fun getInstance(): SearchMoviesApi {
            if (movieService === null) {
                movieService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(SearchMoviesApi::class.java)
            }

            return movieService!!
        }
    }
}

interface MovieDetailsApi {
    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: String,
        @Query("api_key") api_key: String = API_KEY
    ) : Movie

    companion object {
        var movieService: MovieDetailsApi? = null

        fun getInstance(): MovieDetailsApi {
            if (movieService === null) {
                movieService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MovieDetailsApi::class.java)
            }

            return movieService!!
        }
    }
}