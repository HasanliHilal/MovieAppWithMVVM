package com.example.mvvm_project.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.mvvm_project.data.db.ArtistDao
import com.example.mvvm_project.data.db.MovieDao
import com.example.mvvm_project.data.db.TMDBDatabase
import com.example.mvvm_project.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDa0a(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }
    @Provides
    @Singleton
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }
    @Provides
    @Singleton
    fun providTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvShowDao()
    }
}