package com.example.madlevel6task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_movie_info.*
import kotlinx.android.synthetic.main.item_movie.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MovieInfoFragment : Fragment() {
    private val viewModel: MovieViewModel by activityViewModels()
    private lateinit var currentMovie : Movie

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        currentMovie = viewModel.selectedMovie.value!!

        Glide.with(requireContext()).load(currentMovie.getPosterURL()).into(ivPoster)
        Glide.with(requireContext()).load(currentMovie.getBackDropURL()).into(ivBackdrop)
        tvRelease.text = currentMovie.releaseDate
        tvOverview.text = currentMovie.overview
        tvTitle.text = currentMovie.title
        tvRating.text = currentMovie.voteAverage.toString()
    }
}