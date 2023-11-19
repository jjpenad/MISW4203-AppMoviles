package com.example.vinilosapp.data.network.artists

import com.example.vinilosapp.data.model.Artist
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ArtistAPIClient {

    @GET("/artists")
    suspend fun getArtists():Response<List<Artist>>
    @GET("/artists/{id}")
    suspend fun getArtistById(@Path("id") artistId: Int): Response<Artist>


}