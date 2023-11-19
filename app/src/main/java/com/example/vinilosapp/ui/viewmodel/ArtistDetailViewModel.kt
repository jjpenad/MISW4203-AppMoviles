package com.example.vinilosapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vinilosapp.data.model.Artist
import com.example.vinilosapp.data.network.artists.ArtistService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ArtistDetailViewModel @Inject constructor(
    private val artistService: ArtistService
): ViewModel() {

    val artist = MutableLiveData<Artist?>()

    fun getArtistById(id: Int){
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                var artistDetail = artistService.getArtistById(id)
                if (artistDetail != null) {
                    artist.postValue(artistDetail)
                }
            }
        }
    }
}