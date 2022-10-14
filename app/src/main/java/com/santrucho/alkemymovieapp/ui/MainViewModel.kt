package com.santrucho.alkemymovieapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.santrucho.alkemymovieapp.domain.MovieRepository
import com.santrucho.alkemymovieapp.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo:MovieRepository) : ViewModel() {

    val fetchMovieList = liveData(Dispatchers.IO){
        try{
            val movieList = repo.getMovieList()
            emit(movieList)
        } catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }
}