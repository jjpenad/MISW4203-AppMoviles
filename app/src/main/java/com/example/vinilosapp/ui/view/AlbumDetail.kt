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
import com.bumptech.glide.Glide
import com.example.vinilosapp.AlbumProvider
import com.example.vinilosapp.data.model.Album
import com.example.vinilosapp.data.network.albums.AlbumService
import com.example.vinilosapp.ui.view.adapter.AlbumAdapter
import com.example.vinilosapp.databinding.ActivityMainBinding
import com.example.vinilosapp.databinding.DetailAlbumBinding
import com.example.vinilosapp.ui.viewmodel.AlbumDetailViewModel
import com.example.vinilosapp.ui.viewmodel.AlbumListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class AlbumDetail : AppCompatActivity() {

    private lateinit var binding: DetailAlbumBinding

    private val albumDetailViewModel: AlbumDetailViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DetailAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        searchAlbumById()
    }
    private fun searchAlbumById(){
        val albumId = 100
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