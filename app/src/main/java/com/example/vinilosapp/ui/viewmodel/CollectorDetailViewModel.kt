package com.example.vinilosapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vinilosapp.data.model.Collector
import com.example.vinilosapp.data.network.collectors.CollectorService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CollectorDetailViewModel @Inject constructor(
    private val CollectorService: CollectorService
): ViewModel() {

    val collector = MutableLiveData<Collector?>()

    fun getCollectorById(id: Int){
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                var collectorDetail = CollectorService.getCollectorById(id)
                if (collectorDetail != null) {
                    collector.postValue(collectorDetail)
                }
            }
        }
    }
}