package com.example.vinilosapp.ui.view

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosapp.AlbumProvider
import com.example.vinilosapp.data.model.Album
import com.example.vinilosapp.data.network.albums.AlbumService
import com.example.vinilosapp.ui.view.adapter.AlbumAdapter
import com.example.vinilosapp.databinding.ActivityMainBinding
import com.example.vinilosapp.ui.viewmodel.AlbumListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AlbumAdapter

    private val albumListViewModel: AlbumListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerAlbum
        initRecyclerView()
        searchAlbums()
    }




    private fun initRecyclerView(){
        adapter = AlbumAdapter()
        binding.recyclerAlbum.layoutManager = LinearLayoutManager(this)
        binding.recyclerAlbum.adapter = adapter
    }

    private fun searchAlbums(){
        albumListViewModel.albums.observe(this@MainActivity, Observer {
            val albumList: List<Album>? = it
            runOnUiThread{
                adapter.updateList(albumList)
            }
        })

        albumListViewModel.getAlbums()
    }


}