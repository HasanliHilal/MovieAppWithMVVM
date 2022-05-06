package com.example.mvvm_project.presentation.di.core

import com.example.mvvm_project.data.api.TMDBService
import com.example.mvvm_project.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.mvvm_project.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.mvvm_project.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.mvvm_project.data.repository.movie.datasourceImpl.MovieCahceDataSourceImpl
import com.example.mvvm_project.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.mvvm_project.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.mvvm_project.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return  MovieRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }
    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDataSource{
        return  ArtistRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }
    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService):TvShowRemoteDataSource{
        return  TvShowRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }
}