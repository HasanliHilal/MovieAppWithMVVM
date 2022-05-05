package com.example.mvvm_project.data.repository.movie

import com.example.mvvm_project.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun  getMoviesFromCache():List<Movie>
    suspend fun  saveMoviesToCache(movies:List<Movie>)
}