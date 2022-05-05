package com.example.mvvm_project.domain.usecase

import com.example.mvvm_project.data.model.artist.Artist
import com.example.mvvm_project.domain.repository.ArtistRepository
import com.example.mvvm_project.domain.repository.MovieRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun  execute():List<Artist>? = artistRepository.updateArtists()
}