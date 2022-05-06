package com.example.mvvm_project.data.repository.tvshow.datasource

import com.example.mvvm_project.data.model.artist.Artist
import com.example.mvvm_project.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsTODB(tvShows: List<TvShow>)
    suspend fun clearAll()
}