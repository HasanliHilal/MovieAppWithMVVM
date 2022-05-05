package com.example.mvvm_project.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_project.data.model.artist.Artist

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(artists: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteTvShows()

    @Query("SELECT * FROM popular_artists")
    suspend fun getTvShows(artists: List<Artist>)
}