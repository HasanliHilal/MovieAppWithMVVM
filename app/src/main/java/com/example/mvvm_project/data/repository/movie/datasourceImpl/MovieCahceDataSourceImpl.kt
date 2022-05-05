package com.example.mvvm_project.data.repository.movie

import com.example.mvvm_project.data.model.movie.Movie
import com.example.mvvm_project.data.repository.movie.datasource.MovieCacheDataSource

class MovieCahceDataSourceImpl : MovieCacheDataSource {
    private  var movieList=ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList=ArrayList(movies)
    }
}