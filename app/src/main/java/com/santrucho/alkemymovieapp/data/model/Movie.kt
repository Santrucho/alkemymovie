package com.santrucho.alkemymovieapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id")
    val id : String = "",
    @SerializedName("title")
    val name : String = "",
    @SerializedName("overview")
    val description : String = "",
    @SerializedName("poster_path")
    val poster : String = ""
) : Parcelable


data class MovieList(
    @SerializedName("results")
    val movieList : List<Movie> = listOf()
)