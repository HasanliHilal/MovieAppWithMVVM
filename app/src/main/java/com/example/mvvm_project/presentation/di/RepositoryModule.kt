package com.example.mvvm_project.presentation.di

import com.example.mvvm_project.data.repository.artist.ArtistRepositoryImpl
import com.example.mvvm_project.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvm_project.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvm_project.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.mvvm_project.data.repository.movie.MovieRepositoryImpl
import com.example.mvvm_project.data.repository.movie.datasource.MovieCacheDataSource
import com.example.mvvm_project.data.repository.movie.datasource.MovieLocalDataSource
import com.example.mvvm_project.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.mvvm_project.data.repository.tvshow.TvShowRepositoryImpl
import com.example.mvvm_project.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvm_project.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.mvvm_project.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.mvvm_project.domain.repository.ArtistRepository
import com.example.mvvm_project.domain.repository.MovieRepository
import com.example.mvvm_project.domain.repository.TvShowRepository
import dagger.Module

@Module
class RepositoryModule {
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ):MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ):ArtistRepository{
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ):TvShowRepository{
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }
}