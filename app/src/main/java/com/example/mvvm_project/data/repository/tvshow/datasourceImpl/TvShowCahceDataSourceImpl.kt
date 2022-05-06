package com.example.mvvm_project.data.repository.tvshow.datasourceImpl

import com.example.mvvm_project.data.model.artist.Artist
import com.example.mvvm_project.data.model.tvshow.TvShow
import com.example.mvvm_project.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvm_project.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCahceDataSourceImpl : TvShowCacheDataSource {
    private  var tvShowList=ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }
    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList=ArrayList(tvShows)
    }
}