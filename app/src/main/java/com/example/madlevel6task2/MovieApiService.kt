package com.example.madlevel6task2

import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY: String = "6ac16c4ac4b67662517661bdc05f24d0"

interface MovieApiService {
    @GET("discover/movie?api_key=$API_KEY&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    suspend fun getMovies(@Query("year") year: String): Movies
}