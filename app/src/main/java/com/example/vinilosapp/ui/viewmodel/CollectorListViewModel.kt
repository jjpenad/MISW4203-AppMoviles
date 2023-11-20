package com.example.vinilosapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vinilosapp.data.model.Album
import com.example.vinilosapp.data.model.Collector
import com.example.vinilosapp.data.network.albums.AlbumService
import com.example.vinilosapp.data.network.collectors.CollectorService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CollectorListViewModel @Inject constructor(
    private val collectorService: CollectorService
): ViewModel() {

    val collectors = MutableLiveData<List<Collector>?>()

    fun getCollectors(){
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                var collectorsList = collectorService.getCollectors()
                if (collectorsList != null) {
                    collectors.postValue(ArrayList(collectorsList.map { it.copy() }))
                }
            }
        }
    }
}