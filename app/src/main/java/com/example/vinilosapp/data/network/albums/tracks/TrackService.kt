package com.example.vinilosapp.data.network.albums.tracks

import android.util.Log
import com.example.vinilosapp.data.model.Album
import com.example.vinilosapp.data.model.CreateTrackDTO
import com.example.vinilosapp.data.model.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TrackService @Inject constructor(
    private val api: TrackAPIClient
)  {

    suspend fun getAlbumTracks(albumId: Int): List<Track>? {
        return withContext(Dispatchers.IO){
            val response = api.getAlbumTracks(albumId)
            if(response.isSuccessful){
                print(response.body())
                Log.i("TrackService", "Funciona listar")
                response.body()
            }
            else{
                Log.i("TrackService", "Falla Listar")
                listOf()
            }
        }
    }

    suspend fun getAlbumTrackById(albumId: Int, trackId: Int): Track? {
        return withContext(Dispatchers.IO){
            val response = api.getAlbumTrackById(albumId, trackId)
            if(response.isSuccessful){
                Log.i("TrackService", "Funciona Get By Id")
                response.body()
            }
            else{
                Log.i("TrackService", "Falla Get By Id")
                null
            }
        }
    }

    suspend fun addTrackToAlbum(albumId: Int, track: Track): Track? {
        return withContext(Dispatchers.IO){
            val response = api.addTrackToAlbum(albumId, CreateTrackDTO(track.name, track.duration))
            if(response.isSuccessful){
                Log.i("TrackService", "Funciona addTrackToAlbum")
                response.body()
            }
            else{
                Log.i("TrackService", "Falla addTrackToAlbum")
                Log.i("TrackService", response.body().toString())
                null
            }
        }
    }
}