package com.example.vinilosapp.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vinilosapp.data.model.Artist
import com.example.vinilosapp.databinding.ActivityMainBinding
import com.example.vinilosapp.ui.view.adapter.ArtistAdapter
import com.example.vinilosapp.ui.viewmodel.ArtistListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistList : AppCompatActivity(), ArtistAdapter.OnItemClickListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArtistAdapter

    private val artistListViewModel: ArtistListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)
        binding.myToolbar.title="Artists"

        binding.recyclerAlbum
        initRecyclerView()
        searchArtist()
    }

    private fun initRecyclerView(){
        adapter = ArtistAdapter()
        adapter.setOnItemClickListener(this) // Set the click listener
        binding.recyclerAlbum.layoutManager = LinearLayoutManager(this)
        binding.recyclerAlbum.adapter = adapter
    }

    private fun searchArtist(){
        artistListViewModel.artists.observe(this@ArtistList) {
            val artistList: List<Artist>? = it
            runOnUiThread {
                adapter.updateList(artistList)
            }
        }

        artistListViewModel.getArtists()
    }

    override fun onItemClick(artistId: Int) {
        val intent = Intent(this, ArtistDetail::class.java)
        intent.putExtra("ARTIST_ID", artistId.toString())
        startActivity(intent)
    }


}