package com.example.vinilosapp.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.vinilosapp.data.model.Album
import com.example.vinilosapp.databinding.DetailAlbumBinding
import com.example.vinilosapp.ui.view.adapter.AlbumAdapter
import com.example.vinilosapp.ui.view.adapter.AlbumTrackAdapter
import com.example.vinilosapp.ui.viewmodel.AlbumDetailViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AlbumDetail : AppCompatActivity(), AlbumTrackAdapter.OnItemClickListener {

    private lateinit var binding: DetailAlbumBinding
    private lateinit var adapter: AlbumTrackAdapter

    private val albumDetailViewModel: AlbumDetailViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DetailAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the message from the intent
        // Get the message from the intent
        val intent = intent
        val albumId: String? = intent.getStringExtra("ALBUM_ID")
        print(albumId)
        binding.rvTracks
        initRecyclerView()
        initAddTrackButton(albumId?.toInt())
        searchAlbumById(albumId?.toInt())
        searchAlbumTracks(albumId?.toInt())
    }

    private fun searchAlbumById(id:Int?){
        val albumId = id ?: 100
        albumDetailViewModel.album.observe(this@AlbumDetail, Observer {
            runOnUiThread {
                setAlbumInfo(it)
            }
        })

        albumDetailViewModel.getAlbumById(albumId)
    }

    private fun searchAlbumTracks(id: Int?){
        val albumId = id ?: 100
        albumDetailViewModel.tracks.observe(this@AlbumDetail, Observer {
            runOnUiThread {
                adapter.updateList(it)
            }
        })
        albumDetailViewModel.getAlbumTracks(albumId)
    }

    private fun initRecyclerView(){
        adapter = AlbumTrackAdapter()
        adapter.setOnItemClickListener(this)
        binding.rvTracks.layoutManager = LinearLayoutManager(this)
        binding.rvTracks.adapter = adapter
    }

    private fun initAddTrackButton(albumId: Int?){
        binding.btnAddTrack.setOnClickListener {
            print("HOLAA")
            val intent = Intent(this, AlbumAddTrack::class.java)
            intent.putExtra("ALBUM_ID", albumId.toString())
            startActivity(intent)
        }
    }

    private fun setAlbumInfo(album: Album?) {
        if (album != null) {
            binding.tvAlbumTitle.text = album.name
            binding.tvAlbumDescription.text = album.description
            binding.tvGenre.text = album.genre
            Glide.with(binding.ivAlbumCover.context).load(album.cover).into(binding.ivAlbumCover)
        }
    }

    override fun onItemClick(albumId: Double) {
        TODO("Not yet implemented")
        print("HOLAA Tracks")
    }


}