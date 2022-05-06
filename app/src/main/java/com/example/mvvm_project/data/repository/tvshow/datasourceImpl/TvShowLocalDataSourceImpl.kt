package com.example.mvvm_project.data.repository.tvshow.datasourceImpl

import com.example.mvvm_project.data.db.ArtistDao
import com.example.mvvm_project.data.db.TvShowDao
import com.example.mvvm_project.data.model.artist.Artist
import com.example.mvvm_project.data.model.tvshow.TvShow
import com.example.mvvm_project.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvm_project.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private  val tvShowDao: TvShowDao): TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsTODB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope((Dispatchers.IO)).launch {
            tvShowDao.deleteTvShows()
        }
    }

}