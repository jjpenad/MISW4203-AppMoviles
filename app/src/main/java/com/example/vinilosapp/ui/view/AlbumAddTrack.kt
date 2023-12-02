package com.example.vinilosapp.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.vinilosapp.data.model.Artist
import com.example.vinilosapp.data.model.Track
import com.example.vinilosapp.databinding.AddTrackBinding
import com.example.vinilosapp.databinding.DetailArtistBinding
import com.example.vinilosapp.ui.viewmodel.AlbumDetailViewModel
import com.example.vinilosapp.ui.viewmodel.ArtistDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumAddTrack : AppCompatActivity() {

    private lateinit var binding: AddTrackBinding

    private val albumDetailViewModel: AlbumDetailViewModel by viewModels()
    private var albumId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AddTrackBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Get the message from the intent
        // Get the message from the intent
        val intent = intent
        albumId = intent.getStringExtra("ALBUM_ID").toString()
        initCreateTrackButton(albumId.toInt())
    }
    private fun initCreateTrackButton(id:Int?){
        binding.btnCreateTrack.setOnClickListener{
            if (id != null) {
                this.addTrack(id, Track(0.0, binding.txtName.text.toString(), binding.txtDuration.text.toString()))
            }
        }
    }

    private fun addTrack(albumId:Int, track: Track){
        albumDetailViewModel.addAlbumTrack(albumId,track)
        this.finish()
    }

}