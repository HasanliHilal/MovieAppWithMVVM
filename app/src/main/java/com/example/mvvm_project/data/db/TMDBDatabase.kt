package com.example.mvvm_project.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm_project.data.db.ArtistDao
import com.example.mvvm_project.data.db.MovieDao
import com.example.mvvm_project.data.db.TvShowDao
import com.example.mvvm_project.data.model.artist.Artist
import com.example.mvvm_project.data.model.movie.Movie
import com.example.mvvm_project.data.model.tvshow.TvShow

@Database(entities = [Movie::class,TvShow::class,Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {

     abstract  fun movieDao(): MovieDao
     abstract  fun artistDao(): ArtistDao
     abstract  fun tvShowDao(): TvShowDao
}