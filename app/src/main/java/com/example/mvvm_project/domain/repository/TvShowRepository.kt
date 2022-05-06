package com.example.mvvm_project.domain.repository

import com.example.mvvm_project.data.model.movie.Movie
import com.example.mvvm_project.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>
}