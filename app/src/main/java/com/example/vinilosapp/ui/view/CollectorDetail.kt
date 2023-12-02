package com.example.vinilosapp.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.vinilosapp.data.model.Collector
import com.example.vinilosapp.databinding.DetailCollectorBinding
import com.example.vinilosapp.ui.viewmodel.CollectorDetailViewModel

import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CollectorDetail : AppCompatActivity() {

    private lateinit var binding: DetailCollectorBinding

    private val collectorDetailViewModel: CollectorDetailViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DetailCollectorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Get the message from the intent
        // Get the message from the intent
        val intent = intent
        val collectorId: String? = intent.getStringExtra("COLLECTOR_ID")
        searchCollectorById(collectorId?.toInt())
    }
    private fun searchCollectorById(id:Int?){
        val collectorId = id ?: 100
        collectorDetailViewModel.collector.observe(this@CollectorDetail, Observer {
            runOnUiThread {
                setCollectorInfo(it)
            }
        })

        collectorDetailViewModel.getCollectorById(collectorId)
    }

    private fun setCollectorInfo(collector: Collector?) {
        if (collector != null) {
            binding.ivCollectorName.text =collector.name
            binding.ivCollectorPhone.text=collector.telephone
            binding.ivCollectorEmail.text=collector.email
            val lista=collector.comments
            for(i in lista.indices){
                binding.ivCollectorCommentDescription.text= lista[i].description
                binding.ivCollectorCommentRating.rating= lista[i].rating.toFloat()
            }

        }
    }


}