package com.example.vinilosapp.data.network.artists

import android.util.Log
import com.example.vinilosapp.data.model.Artist
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArtistService @Inject constructor(
    private val api:ArtistAPIClient
)  {

    suspend fun getArtists(): List<Artist>? {
        return withContext(Dispatchers.IO){
            val response = api.getArtists()
            if(response.isSuccessful){
                Log.i("ArtistService", "Falla Listar")
                response.body()
            }
            else{
                Log.i("ArtistService", "Funciona listar")
                listOf()
            }
        }
    }

    suspend fun getArtistById(id:Int): Artist? {
        return withContext(Dispatchers.IO){
            val response = api.getArtistById(id)
            if(response.isSuccessful){
                Log.i("ArtistService", "Falla Get By Id")
                response.body()
            }
            else{
                Log.i("ArtistService", "Funciona Get By Id")
                null
            }
        }
    }
}