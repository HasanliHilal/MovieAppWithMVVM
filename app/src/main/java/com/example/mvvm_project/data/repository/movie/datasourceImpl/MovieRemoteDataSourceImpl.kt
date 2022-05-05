package com.example.mvvm_project.data.repository.movie

import com.example.mvvm_project.data.api.TMDBService
import com.example.mvvm_project.data.model.movie.MovieList
import com.example.mvvm_project.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}