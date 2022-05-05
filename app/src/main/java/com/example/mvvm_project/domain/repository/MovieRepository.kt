package com.example.mvvm_project.domain.repository

import com.example.mvvm_project.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?

}