package com.example.mvvm_project.presentation.di.movie

import com.example.mvvm_project.presentation.artist.ArtistActivity
import com.example.mvvm_project.presentation.di.artist.ArtistSubComponent
import com.example.mvvm_project.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }

}