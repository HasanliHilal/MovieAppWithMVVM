package com.example.mvvm_project.data.repository.artist.datasource

import com.example.mvvm_project.data.model.artist.ArtisList
import com.example.mvvm_project.data.model.movie.Movie
import com.example.mvvm_project.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtisList>
}