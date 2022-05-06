package com.example.mvvm_project.data.repository.movie.datasourceImpl

import com.example.mvvm_project.data.db.MovieDao
import com.example.mvvm_project.data.model.movie.Movie
import com.example.mvvm_project.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private  val movieDao: MovieDao): MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
       return movieDao.getMovies()
    }

    override suspend fun saveMoviesTODB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope((Dispatchers.IO)).launch {
            movieDao.deleteAllMovies()
        }
    }
}