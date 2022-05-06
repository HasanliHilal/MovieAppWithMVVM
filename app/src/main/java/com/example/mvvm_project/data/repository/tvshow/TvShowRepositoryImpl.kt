package com.example.mvvm_project.data.repository.tvshow

import android.util.Log
import com.example.mvvm_project.data.model.artist.Artist
import com.example.mvvm_project.data.model.tvshow.TvShow
import com.example.mvvm_project.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvm_project.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvm_project.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.mvvm_project.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvm_project.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.mvvm_project.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.mvvm_project.domain.repository.ArtistRepository
import com.example.mvvm_project.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return  getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newListOfTvShows:List<TvShow> = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsTODB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return  newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response=tvShowRemoteDataSource.getTvShows()
            val body=response.body()
            if(body!=null){
                tvShowList=body.tvShows
            }
        } catch (exception:Exception) {
            Log.i("MyTag",exception.message.toString())
        }
        return tvShowList
    }
    suspend fun  getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList=tvShowLocalDataSource.getTvShowsFromDB()
        } catch (exception:Exception) {
            Log.i("MyTag",exception.message.toString())
        }
        if(tvShowList.size>0){
              return tvShowList
        }else{
            tvShowList=getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsTODB(tvShowList)
        }
        return tvShowList
    }
    suspend fun  getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList=tvShowCacheDataSource.getTvShowsFromCache()
        } catch (exception:Exception) {
            Log.i("MyTag",exception.message.toString())
        }
        if(tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList=getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }

}