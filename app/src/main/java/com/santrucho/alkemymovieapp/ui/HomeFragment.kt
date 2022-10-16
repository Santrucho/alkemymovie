package com.santrucho.alkemymovieapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.santrucho.alkemymovieapp.R
import com.santrucho.alkemymovieapp.data.model.Movie
import com.santrucho.alkemymovieapp.databinding.FragmentHomeBinding
import com.santrucho.alkemymovieapp.domain.DataSource
import com.santrucho.alkemymovieapp.domain.MovieRepositoryImpl
import com.santrucho.alkemymovieapp.vo.Resource

class HomeFragment : Fragment(), MovieAdapter.OnMovieClickListener {

    private val viewModel by lazy {
        ViewModelProviders.of(
            this, VMFactory(MovieRepositoryImpl(DataSource()))
        ).get(
            MainViewModel::class.java
        )
    }

    //private lateinit var adapter : MovieAdapter
    //private lateinit var movieList : List<Movie>

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        //movieList = ArrayList()
        //binding.recyclerView.adapter = adapter


        viewModel.fetchMovieList.observe(viewLifecycleOwner, Observer{ result ->
            when(result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.adapter = MovieAdapter(requireContext(),result.data,this)
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(),"Ocurrio un error al obtener las peliculas", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onMovieClick(movie:Movie){
       val bundle = Bundle()
        bundle.putParcelable("movie",movie)
        findNavController().navigate(R.id.action_homeFragment_to_movieDetailFragment,bundle)
    }

    private fun setupRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL)
        )
    }


}