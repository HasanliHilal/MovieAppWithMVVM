package com.example.mvvm_project.presentation.di.core

import com.example.mvvm_project.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvm_project.data.repository.artist.datasourceImpl.ArtistCahceDataSourceImpl
import com.example.mvvm_project.data.repository.movie.datasource.MovieCacheDataSource
import com.example.mvvm_project.data.repository.movie.datasourceImpl.MovieCahceDataSourceImpl
import com.example.mvvm_project.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvm_project.data.repository.tvshow.datasourceImpl.TvShowCahceDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun movieCacheDataSource():MovieCacheDataSource{
        return  MovieCahceDataSourceImpl()
    }
    @Singleton
    @Provides
    fun artistCacheDataSource():ArtistCacheDataSource{
        return  ArtistCahceDataSourceImpl()
    }
    @Singleton
    @Provides
    fun tvShowCacheDataSource():TvShowCacheDataSource{
        return  TvShowCahceDataSourceImpl()
    }
}