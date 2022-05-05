package com.example.mvvm_project.data.repository.artist

import com.example.mvvm_project.data.model.artist.Artist
import com.example.mvvm_project.data.model.movie.Movie
import com.example.mvvm_project.data.repository.movie.datasource.MovieCacheDataSource

class ArtistCahceDataSourceImpl : ArtistCacheDataSource {
    private  var artistList=ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }
    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList=ArrayList(artists)
    }
}