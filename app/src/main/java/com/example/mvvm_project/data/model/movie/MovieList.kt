package com.example.mvvm_project.data.model.movie


import com.example.mvvm_project.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val results: List<Movie>,
)