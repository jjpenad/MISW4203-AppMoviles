package com.example.vinilosapp.data.network.albums

import android.util.Log
import com.example.vinilosapp.data.model.Album
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AlbumService @Inject constructor(
    private val api:AlbumAPIClient
)  {

    suspend fun getAlbums(): List<Album>? {
        return withContext(Dispatchers.IO){
            val response = api.getAlbums()
            if(response.isSuccessful){
                Log.i("AlbumService", "Falla Listar")
                response.body()
            }
            else{
                Log.i("AlbumService", "Funciona listar")
                listOf()
            }
        }
    }

    suspend fun getAlbumById(id:Int): Album? {
        return withContext(Dispatchers.IO){
            val response = api.getAlbumById(id)
            if(response.isSuccessful){
                Log.i("AlbumService", "Falla Get By Id")
                response.body()
            }
            else{
                Log.i("AlbumService", "Funciona Get By Id")
                null
            }
        }
    }
}