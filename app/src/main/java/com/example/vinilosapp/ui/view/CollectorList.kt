package com.example.vinilosapp.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosapp.data.model.Collector
import com.example.vinilosapp.databinding.ActivityMain3Binding
import com.example.vinilosapp.ui.view.adapter.CollectorAdapter
import com.example.vinilosapp.ui.viewmodel.CollectorListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CollectorList : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain3Binding
    private lateinit var adapter: CollectorAdapter

    private val collectorListViewModel: CollectorListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)
        binding.myToolbar.title="Collectors"

        binding.recyclerCollector
        initRecyclerView()
        searchCollectors()
    }




    private fun initRecyclerView(){
        adapter = CollectorAdapter()
        binding.recyclerCollector.layoutManager = LinearLayoutManager(this)
        binding.recyclerCollector.adapter = adapter
    }

    private fun searchCollectors(){
        collectorListViewModel.collectors.observe(this@CollectorList, Observer {
            val collectorList: List<Collector>? = it
            runOnUiThread{
                adapter.updateList(collectorList)
            }
        })

        collectorListViewModel.getCollectors()
    }


}