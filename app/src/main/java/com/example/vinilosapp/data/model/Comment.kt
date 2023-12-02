package com.example.vinilosapp.data.model

import com.google.gson.annotations.SerializedName

data class Comment(
    @SerializedName("id") val id: Double,
    @SerializedName("description") val description: String,
    @SerializedName("rating") val rating: Int
)
