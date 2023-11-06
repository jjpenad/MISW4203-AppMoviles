package com.example.vinilosapp.data.network.albums

import com.example.vinilosapp.data.model.Album
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumAPIClient {

    @GET("/albums")
    suspend fun getAlbums():Response<List<Album>>
    @GET("/albums/{id}")
    suspend fun getAlbumById(@Path("id") albumId: Int): Response<Album>


}