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
class AlbumListViewModel @Inject constructor(
    private val albumService: AlbumService
): ViewModel() {

    val albums = MutableLiveData<List<Album>?>()

    fun getAlbums(){
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                var albumsList = albumService.getAlbums()
                if (albumsList != null) {
                    albums.postValue(ArrayList(albumsList.map { it.copy() }))
                }
            }
        }
    }
}