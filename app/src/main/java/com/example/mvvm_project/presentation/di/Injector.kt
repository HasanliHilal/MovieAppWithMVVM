package com.example.mvvm_project.presentation.di

import com.example.mvvm_project.data.model.tvshow.TvShow
import com.example.mvvm_project.presentation.di.artist.ArtistSubComponent
import com.example.mvvm_project.presentation.di.movie.MovieSubComponent
import com.example.mvvm_project.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
}