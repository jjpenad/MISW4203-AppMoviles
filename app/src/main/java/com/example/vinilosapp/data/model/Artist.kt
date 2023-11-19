package com.example.vinilosapp.data.model

import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("id") val id: Double,
    @SerializedName("name") val name: String,
    @SerializedName("cover") val cover: String,
    @SerializedName("description") val description: String

)
