package com.example.mvvm_project.data.repository.tvshow.datasourceImpl

import com.example.mvvm_project.data.api.TMDBService
import com.example.mvvm_project.data.model.artist.ArtisList
import com.example.mvvm_project.data.model.tvshow.TvShowList
import com.example.mvvm_project.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.mvvm_project.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList>  = tmdbService.getPopularTvShows(apiKey)

}