package com.example.vinilosapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vinilosapp.data.model.Album
import com.example.vinilosapp.data.network.albums.AlbumService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AlbumDetailViewModel @Inject constructor(
    private val albumService: AlbumService
): ViewModel() {

    val album = MutableLiveData<Album?>()

    fun getAlbumById(id: Int){
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                var albumDetail = albumService.getAlbumById(id)
                if (albumDetail != null) {
                    album.postValue(albumDetail)
                }
            }
        }
    }
}