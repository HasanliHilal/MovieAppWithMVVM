package com.example.mvvm_project.data.repository.artist

import com.example.mvvm_project.data.api.TMDBService
import com.example.mvvm_project.data.model.artist.ArtisList
import com.example.mvvm_project.data.model.movie.MovieList
import com.example.mvvm_project.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtisList>  = tmdbService.getPopularArtist(apiKey)

}