package com.example.mvvm_project.domain.repository

import com.example.mvvm_project.data.model.artist.Artist


interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>
}