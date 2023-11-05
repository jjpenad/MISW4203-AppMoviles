package com.example.vinilosapp.data.network.albums

import com.example.vinilosapp.data.model.Album
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AlbumService @Inject constructor(
    private val api:AlbumAPIClient
)  {

    suspend fun getAlbums(): Array<Album>? {
        return withContext(Dispatchers.IO){
            val response = api.getAlbums()
            response.body()
        }
    }

    suspend fun getAlbumById(id:Int): Album? {
        return withContext(Dispatchers.IO){
            val response = api.getAlbumById(id)
            response.body()
        }
    }
}