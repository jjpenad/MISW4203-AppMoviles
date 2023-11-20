package com.example.vinilosapp.data.network.collectors
import android.util.Log
import com.example.vinilosapp.data.model.Collector
import com.example.vinilosapp.data.network.collectors.CollectorAPIClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CollectorService @Inject constructor(
    private val api: CollectorAPIClient
)  {

    suspend fun getCollectors(): List<Collector>? {
        return withContext(Dispatchers.IO){
            val response = api.getCollectors()
            if(response.isSuccessful){
                Log.i("CollectorService", "Falla Listar")
                response.body()
            }
            else{
                Log.i("CollectorService", "Funciona listar")
                listOf()
            }
        }
    }

    suspend fun getCollectorById(id:Int): Collector? {
        return withContext(Dispatchers.IO){
            val response = api.getCollectorById(id)
            if(response.isSuccessful){
                Log.i("CollectorService", "Falla Get By Id")
                response.body()
            }
            else{
                Log.i("CollectorService", "Funciona Get By Id")
                null
            }
        }
    }
}