package com.example.madlevel6task2

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val moviesRepository = MovieRepository()
    val movies = moviesRepository.movies


    private val _errorText: MutableLiveData<String> = MutableLiveData()

    val errorText: LiveData<String>
        get() = _errorText

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

    fun setCurrentSelectedMovie(newMovie: Movie) {
       viewModelScope.launch {
           moviesRepository.showMovie(newMovie)
       }
    }
}