package com.example.vinilosapp.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.vinilosapp.data.model.Artist
import com.example.vinilosapp.databinding.DetailArtistBinding
import com.example.vinilosapp.ui.viewmodel.ArtistDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistDetail : AppCompatActivity() {

    private lateinit var binding: DetailArtistBinding

    private val artistDetailViewModel: ArtistDetailViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DetailArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Get the message from the intent
        // Get the message from the intent
        val intent = intent
        val artistId: String? = intent.getStringExtra("ARTIST_ID")
        print(artistId)
        searchArtistById(artistId?.toInt())
    }
    private fun searchArtistById(id:Int?){
        val artistId = id ?: 100
        artistDetailViewModel.artist.observe(this@ArtistDetail, Observer {
            runOnUiThread {
                setArtistInfo(it)
            }
        })

        artistDetailViewModel.getArtistById(artistId)
    }

    private fun setArtistInfo(artist: Artist?) {
        if (artist != null) {
            binding.tvArtistTitle.text = artist.name
            binding.tvArtistDescription.text = artist.description
            Glide.with(binding.ivArtistCover.context).load(artist.cover).into(binding.ivArtistCover)
        }
    }


}