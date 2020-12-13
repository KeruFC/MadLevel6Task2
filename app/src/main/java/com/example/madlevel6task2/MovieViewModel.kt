package com.example.madlevel6task2

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private var _selectedMovie = 0
    private val moviesRepository = MovieRepository()

    val movies = moviesRepository.movies

    private val _errorText: MutableLiveData<String> = MutableLiveData()

    val errorText: LiveData<String>
        get() = _errorText

    val selectedMovie
        get() = _selectedMovie

    /**
     * Method returns all movies by year, if it results in an error it return an error
     */
    fun getMoviesByYear(year: String) {
        viewModelScope.launch {
            try {
                moviesRepository.getMovies(year)
            } catch (error: Throwable) {
                _errorText.value = error.message
                Log.e("Movie error", error.cause.toString())
            }
        }
    }

    fun setCurrentSelectedMovie(index: Int) {
        _selectedMovie = index
    }
}