package com.example.mvvm_project.data.repository.artist

import com.example.mvvm_project.data.model.artist.Artist
import com.example.mvvm_project.data.model.movie.Movie

interface ArtistCacheDataSource {
    suspend fun  getArtistsFromCache():List<Artist>
    suspend fun  saveArtistsToCache(artists:List<Artist>)
}