package com.example.mvvm_project.presentation

import android.app.Application
import com.example.mvvm_project.BuildConfig
import com.example.mvvm_project.presentation.di.Injector

import com.example.mvvm_project.presentation.di.artist.ArtistSubComponent
import com.example.mvvm_project.presentation.di.core.*
import com.example.mvvm_project.presentation.di.movie.MovieSubComponent
import com.example.mvvm_project.presentation.di.tvshow.TvShowSubComponent

class App:Application(), Injector {
    private lateinit var appComponent:AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent= DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }
}