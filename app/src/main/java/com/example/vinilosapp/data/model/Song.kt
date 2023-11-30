package com.example.vinilosapp.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Song(
    val title: String,
    val artist: String,
    var isSelected: Boolean = false)