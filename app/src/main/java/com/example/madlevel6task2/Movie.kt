package com.example.madlevel6task2

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Movie (
    @SerializedName("vote_average") val voteAverage : Double,
    @SerializedName("backdrop_path") val backdropPath : String,
    @SerializedName("overview") val overview : String,
    @SerializedName("poster_path") val posterPath : String,
    @SerializedName("title") val title : String,
    @SerializedName("release_date") val releaseDate : String
) : Parcelable {
    fun getPosterUrl(): String {
        return "https://image.tmdb.org/t/p/original%s".format(posterPath)
    }
    fun getBackdropUrl(): String {
        return "https://image.tmdb.org/t/p/original%s".format(backdropPath)
    }
}
