package com.example.vinilosapp.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.vinilosapp.data.model.Album
import com.example.vinilosapp.databinding.DetailAlbumBinding
import com.example.vinilosapp.ui.viewmodel.AlbumDetailViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AlbumDetail : AppCompatActivity() {

    private lateinit var binding: DetailAlbumBinding

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
        searchAlbumById(albumId?.toInt())
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

    private fun setAlbumInfo(album: Album?) {
        if (album != null) {
            binding.tvAlbumTitle.text = album.name
            binding.tvAlbumDescription.text = album.description
            binding.tvGenre.text = album.genre
            Glide.with(binding.ivAlbumCover.context).load(album.cover).into(binding.ivAlbumCover)
        }
    }


}