package com.example.mvvm_project.data.repository

import com.example.mvvm_project.data.model.movie.Movie
import com.example.mvvm_project.domain.repository.MovieRepository

class MovieRepositoryImpl:MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }
}