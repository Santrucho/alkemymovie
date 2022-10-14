package com.santrucho.alkemymovieapp.domain

import com.santrucho.alkemymovieapp.data.model.Movie
import com.santrucho.alkemymovieapp.data.model.MovieList
import com.santrucho.alkemymovieapp.vo.Resource

interface MovieRepository {
    suspend fun getMovieList() : Resource<List<Movie>>
}