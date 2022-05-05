package com.example.mvvm_project.data.repository.movie

import android.util.Log
import com.example.mvvm_project.data.model.movie.Movie
import com.example.mvvm_project.data.repository.movie.datasource.MovieCacheDataSource
import com.example.mvvm_project.data.repository.movie.datasource.MovieLocalDataSource
import com.example.mvvm_project.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.mvvm_project.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return  getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies:List<Movie> = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesTODB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return  newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response=movieRemoteDataSource.getMovies()
            val body=response.body()
            if(body!=null){
                movieList=body.movies
            }
        } catch (exception:Exception) {
            Log.i("MyTag",exception.message.toString())
        }
        return movieList
    }
    suspend fun  getMoviesFromDB():List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList=movieLocalDataSource.getMoviesFromDB()
        } catch (exception:Exception) {
            Log.i("MyTag",exception.message.toString())
        }
        if(movieList.size>0){
              return movieList
        }else{
            movieList=getMoviesFromAPI()
            movieLocalDataSource.saveMoviesTODB(movieList)
        }
        return movieList
    }
    suspend fun  getMoviesFromCache():List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList=movieCacheDataSource.getMoviesFromCache()
        } catch (exception:Exception) {
            Log.i("MyTag",exception.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }else{
            movieList=getMoviesFromCache()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}