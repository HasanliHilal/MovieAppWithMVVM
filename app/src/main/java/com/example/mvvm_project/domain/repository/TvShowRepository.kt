package com.example.mvvm_project.domain.repository

import com.example.mvvm_project.data.model.movie.Movie

interface TvShowRepository {
    suspend fun getTvShows(): List<Movie>?
    suspend fun updateTvShows(): List<Movie>
}