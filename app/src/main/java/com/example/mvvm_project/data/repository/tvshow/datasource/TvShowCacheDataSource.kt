package com.example.mvvm_project.data.repository.tvshow.datasource

import com.example.mvvm_project.data.model.artist.Artist
import com.example.mvvm_project.data.model.movie.Movie
import com.example.mvvm_project.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun  getTvShowsFromCache():List<TvShow>
    suspend fun  saveTvShowsToCache(tvShows:List<TvShow>)
}