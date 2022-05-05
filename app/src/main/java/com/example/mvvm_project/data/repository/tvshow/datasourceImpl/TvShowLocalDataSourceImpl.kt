package com.example.mvvm_project.data.repository.artist.datasourceImpl

import com.example.mvvm_project.data.db.ArtistDao
import com.example.mvvm_project.data.model.artist.Artist
import com.example.mvvm_project.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private  val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsTODB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope((Dispatchers.IO)).launch {
            artistDao.deleteArtists()
        }
    }

}