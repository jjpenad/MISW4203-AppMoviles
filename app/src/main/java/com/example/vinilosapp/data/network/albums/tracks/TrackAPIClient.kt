package com.example.vinilosapp.data.network.albums.tracks

import com.example.vinilosapp.data.model.Track
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TrackAPIClient {
    @GET("/albums/{albumId}/tracks")
    suspend fun getAlbumTracks(@Path("albumId") albumId: Int): Response<List<Track>>
    @GET("/albums/{albumId}/tracks/{trackId}")
    suspend fun getAlbumTrackById(@Path("albumId") albumId: Int, @Path("trackId") trackId: Int): Response<Track>

    @POST("/albums/{albumId}/tracks")
    suspend fun addTrackToAlbum(@Path("albumId") albumId: Int, @Body track: Track): Response<Track>
}