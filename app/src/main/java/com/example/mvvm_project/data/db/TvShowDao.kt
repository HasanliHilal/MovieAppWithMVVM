package com.example.mvvm_project.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_project.data.model.artist.Artist
import com.example.mvvm_project.data.model.tvshow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(artists: List<TvShow>)

    @Query("DELETE FROM popular_tvshows")
    suspend fun deleteTvShows()

    @Query("SELECT * FROM popular_tvshows")
    suspend fun getTvShows():List<TvShow>
}