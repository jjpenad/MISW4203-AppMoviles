package com.example.vinilosapp.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosapp.data.model.Album
import com.example.vinilosapp.ui.view.adapter.AlbumAdapter
import com.example.vinilosapp.databinding.ActivityMainBinding
import com.example.vinilosapp.ui.viewmodel.AlbumListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumList : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AlbumAdapter

    private val albumListViewModel: AlbumListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)
        binding.myToolbar.title="Albums"

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
        albumListViewModel.albums.observe(this@AlbumList) {
            val albumList: List<Album>? = it
            runOnUiThread {
                adapter.updateList(albumList)
            }
        }

        albumListViewModel.getAlbums()
    }


}