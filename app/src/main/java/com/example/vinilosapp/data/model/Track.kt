package com.example.vinilosapp.data.model

import com.google.gson.annotations.SerializedName

data class Track (
    @SerializedName("id") val id: Double,
    @SerializedName("name") val name: String,
    @SerializedName("duration") val duration: String,
)

data class CreateTrackDTO (
    @SerializedName("name") val name: String,
    @SerializedName("duration") val duration: String,
)