package com.santrucho.alkemymovieapp.domain

import com.santrucho.alkemymovieapp.data.model.Movie
import com.santrucho.alkemymovieapp.vo.Resource
import com.santrucho.alkemymovieapp.vo.RetrofitClient

class DataSource {
    suspend fun getPopularMovie():Resource<List<Movie>>{
        return Resource.Success(RetrofitClient.webService.getPopularMovies().movieList)
    }
}