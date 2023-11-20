package com.example.vinilosapp.data.network.collectors

import com.example.vinilosapp.data.model.Collector
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CollectorAPIClient {

    @GET("/collectors")
    suspend fun getCollectors():Response<List<Collector>>
    @GET("/collectors/{id}")
    suspend fun getCollectorById(@Path("id") collectorId: Int): Response<Collector>


}