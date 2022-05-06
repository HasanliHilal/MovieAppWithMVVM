package com.example.mvvm_project.data.repository.tvshow.datasource

import com.example.mvvm_project.data.model.artist.ArtisList
import com.example.mvvm_project.data.model.movie.Movie
import com.example.mvvm_project.data.model.movie.MovieList
import com.example.mvvm_project.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}