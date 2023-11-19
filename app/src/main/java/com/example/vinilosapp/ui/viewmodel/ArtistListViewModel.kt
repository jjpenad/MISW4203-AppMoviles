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
class ArtistListViewModel @Inject constructor(
    private val artistService: ArtistService
): ViewModel() {

    val artists = MutableLiveData<List<Artist>?>()

    fun getArtists(){
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                var artistsList = artistService.getArtists()
                if (artistsList != null) {
                    artists.postValue(ArrayList(artistsList.map { it.copy() }))
                }
            }
        }
    }
}