package com.santrucho.alkemymovieapp.data.network

import com.santrucho.alkemymovieapp.data.model.MovieList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("popular?api_key=dde7c62f4988449a75b1afbb7200ae2c")
    suspend fun getPopularMovies() : MovieList
}