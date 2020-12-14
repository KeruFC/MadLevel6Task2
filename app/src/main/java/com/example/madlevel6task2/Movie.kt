package com.example.madlevel6task2

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Movie (
    @SerializedName("vote_average") val voteAverage : Double,
    @SerializedName("backdrop_path") val backdropPath : String,
    @SerializedName("overview") val overview : String,
    @SerializedName("poster_path") val posterPath : String,
    @SerializedName("title") val title : String,
    @SerializedName("release_date") val releaseDate : String
) {
    fun getPosterURL() = "https://image.tmdb.org/t/p/w500${posterPath}"
    fun getBackDropURL() = "https://image.tmdb.org/t/p/w500${backdropPath}"
}
