package com.santrucho.alkemymovieapp.domain

import com.santrucho.alkemymovieapp.data.model.Movie
import com.santrucho.alkemymovieapp.data.model.MovieList
import com.santrucho.alkemymovieapp.vo.Resource

class MovieRepositoryImpl(private val dataSource: DataSource) : MovieRepository {

    override suspend fun getMovieList(): Resource<List<Movie>> {
        return dataSource.getPopularMovie()
    }


}