package com.example.madlevel6task2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.withTimeout

class MovieRepository {
    private val movieApiService: MovieApiService = MovieApi.createApi()

    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()

    val movies: LiveData<List<Movie>>
        get() = _movies

    suspend fun getMovies(year: String) {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                movieApiService.getMovies(year)
            }
            _movies.value = result.results

        } catch (error: Throwable) {
            throw MovieError("Unable to load movies list.", error)
        }
    }

    class MovieError(message: String, cause: Throwable) : Throwable(message, cause)

}