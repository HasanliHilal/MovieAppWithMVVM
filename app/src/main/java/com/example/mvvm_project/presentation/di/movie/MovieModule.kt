package com.example.mvvm_project.presentation.di.movie

import com.example.mvvm_project.domain.usecase.GetMoviesUseCase
import com.example.mvvm_project.domain.usecase.UpdateMoviesUseCase
import com.example.mvvm_project.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}