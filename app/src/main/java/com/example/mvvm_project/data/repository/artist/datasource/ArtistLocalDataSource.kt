package com.example.mvvm_project.data.repository.artist

import com.example.mvvm_project.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsTODB(artists: List<Artist>)
    suspend fun clearAll()
}