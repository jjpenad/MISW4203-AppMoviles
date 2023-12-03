package com.example.vinilosapp.di

import com.example.vinilosapp.data.network.albums.AlbumAPIClient
import com.example.vinilosapp.data.network.albums.tracks.TrackAPIClient
import com.example.vinilosapp.data.network.artists.ArtistAPIClient
import com.example.vinilosapp.data.network.collectors.CollectorAPIClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    // Provide Retrofit
    @Singleton
    @Provides
    fun provideBackend(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://vynils-back-heroku.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideAlbumsApiClient(retrofit: Retrofit): AlbumAPIClient {
        return retrofit.create(AlbumAPIClient::class.java)
    }

    @Singleton
    @Provides
    fun provideArtistsApiClient(retrofit: Retrofit): ArtistAPIClient {
        return retrofit.create(ArtistAPIClient::class.java)
    }

    @Singleton
    @Provides
    fun provideCollectorsApiClient(retrofit: Retrofit): CollectorAPIClient {
        return retrofit.create(CollectorAPIClient::class.java)
    }
    
    @Singleton
    @Provides
    fun provideTracksApiClient(retrofit: Retrofit): TrackAPIClient {
        return retrofit.create(TrackAPIClient::class.java)
    }

}