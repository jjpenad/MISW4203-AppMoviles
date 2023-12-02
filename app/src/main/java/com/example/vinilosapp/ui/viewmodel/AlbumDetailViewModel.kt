package com.example.vinilosapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vinilosapp.data.model.Album
import com.example.vinilosapp.data.model.Track
import com.example.vinilosapp.data.network.albums.AlbumService
import com.example.vinilosapp.data.network.albums.tracks.TrackService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AlbumDetailViewModel @Inject constructor(
    private val albumService: AlbumService, private val albumTrackService: TrackService
): ViewModel() {

    val album = MutableLiveData<Album?>()
    val tracks = MutableLiveData<List<Track>?>()

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

    fun getAlbumTracks(albumId: Int){
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                var albumTracks = albumTrackService.getAlbumTracks(albumId)
                if (albumTracks != null) {
                    tracks.postValue(albumTracks)
                }
            }
        }
    }

    fun addAlbumTrack(albumId: Int, track:Track){
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                var albumTrack = albumTrackService.addTrackToAlbum(albumId, track)

            }
        }
    }
}