package com.example.vinilosapp.data.model

import com.google.gson.annotations.SerializedName

data class Collector(
    @SerializedName("id") val id: Double,
    @SerializedName("name") val name: String,
    @SerializedName("telephone") val telephone: String,
    @SerializedName("email") val email: String,
    @SerializedName("comments") val comments : List<Comment>,
    @SerializedName("favoritePerformers") val artists:  List<Artist>,
    @SerializedName("collectorAlbums") val albums: List<Album>

)
