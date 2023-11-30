package com.example.vinilosapp.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Album(
    @SerializedName("id") val id: Double,
    @SerializedName("name") val name: String,
    @SerializedName("cover") val cover: String,
    @SerializedName("releaseDate") val releaseDate: String,
    @SerializedName("description") val description: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("recordLabel") val recordLabel: String,
    @SerializedName("songs") val songs: MutableList<Song>
)
