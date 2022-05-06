package com.example.mvvm_project.data.repository.movie.datasource

import com.example.mvvm_project.data.model.movie.Movie
import com.example.mvvm_project.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}