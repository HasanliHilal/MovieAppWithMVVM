package com.example.mvvm_project.presentation.di.tvshow

import com.example.mvvm_project.domain.usecase.GetArtistsUseCase
import com.example.mvvm_project.domain.usecase.GetTvShowsUseCase
import com.example.mvvm_project.domain.usecase.UpdateArtistsUseCase
import com.example.mvvm_project.domain.usecase.UpdateTvShowsUseCase
import com.example.mvvm_project.presentation.artist.ArtistViewModelFactory
import com.example.mvvm_project.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}