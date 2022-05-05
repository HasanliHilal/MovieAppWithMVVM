package com.example.mvvm_project.data.repository.movie

import com.example.mvvm_project.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesTODB(movies: List<Movie>)
    suspend fun clearAll()
}