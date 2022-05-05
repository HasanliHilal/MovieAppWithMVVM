package com.example.mvvm_project.domain.usecase

import com.example.mvvm_project.data.model.tvshow.TvShow
import com.example.mvvm_project.domain.repository.MovieRepository
import com.example.mvvm_project.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun  execute():List<TvShow>? = tvShowRepository.getTvShows()

}