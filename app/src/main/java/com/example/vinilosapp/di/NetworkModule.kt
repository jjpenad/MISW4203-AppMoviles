package com.example.vinilosapp.di

import com.example.vinilosapp.data.network.albums.AlbumAPIClient
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
            .baseUrl("http://localhost:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideAlbumsApiClient(retrofit: Retrofit): AlbumAPIClient {
        return retrofit.create(AlbumAPIClient::class.java)
    }

}