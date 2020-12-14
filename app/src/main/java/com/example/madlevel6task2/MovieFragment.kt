package com.example.madlevel6task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MovieFragment : Fragment() {
    private val viewModel: MovieViewModel by activityViewModels()
    private val movies = arrayListOf<Movie>()
    private var movieSelectAdapter = MovieAdapter(movies, ::onMovieClick)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeMovies()
    }

    private fun initViews(){
        rvMovies.layoutManager = GridLayoutManager(requireActivity(), 2)
        rvMovies.adapter = movieSelectAdapter

        btSubmit.setOnClickListener { onSubmitClick() }
    }

    private fun observeMovies() {
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            movies.clear()
            movies.addAll(it)
            movieSelectAdapter.notifyDataSetChanged()
        })

        viewModel.errorText.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun onSubmitClick() {
        viewModel.getMoviesByYear(etYear.text.toString())
    }

    private fun onMovieClick(movie: Movie) {
        viewModel.setCurrentSelectedMovie(movie)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }



}