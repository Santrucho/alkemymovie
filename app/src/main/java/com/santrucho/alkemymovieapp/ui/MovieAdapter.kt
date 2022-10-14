package com.santrucho.alkemymovieapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.santrucho.alkemymovieapp.data.model.Movie
import com.santrucho.alkemymovieapp.databinding.ItemMovieBinding

class MovieAdapter(private var listMovies : List<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
        return MovieViewHolder(view.inflate(R.layout.item_movie,parent,false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    @SuppressLint("NotifyDataSetChanged")
    fun setMovieList(movieList : List<Movie>){
        this.listMovies = movieList
        notifyDataSetChanged()
    }
}

class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    private val binding = ItemMovieBinding.bind(itemView)
    private val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"

    fun bind(movie: Movie){
        binding.titleMovie.text = movie.name
        binding.descripMovie.text = movie.description
        Glide.with(itemView).load(IMAGE_URL + movie.poster).into(binding.poster)
    }
}
