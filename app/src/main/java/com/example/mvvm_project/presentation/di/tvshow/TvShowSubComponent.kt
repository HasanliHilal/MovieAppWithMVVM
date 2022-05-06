package com.example.mvvm_project.presentation.di.tvshow

import com.example.mvvm_project.presentation.di.movie.MovieSubComponent
import com.example.mvvm_project.presentation.movie.MovieActivity
import com.example.mvvm_project.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}