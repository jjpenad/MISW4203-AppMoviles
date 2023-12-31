package com.example.vinilosapp.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vinilosapp.databinding.ActivityMainBinding
import com.example.vinilosapp.databinding.DetailArtistBinding
import com.example.vinilosapp.databinding.HomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity: AppCompatActivity() {


    private lateinit var binding: HomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = HomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Settings
        setArtistsAssets()
        setAlbumsAssets()
        setCollectorsAssets()
    }

    private fun setArtistsAssets(){
        binding.albumsBtn.setOnClickListener(){
          navigateToAlbums()
        }
    }

    private fun setAlbumsAssets(){
        binding.artistsBtn.setOnClickListener(){
            navigateToArtists()
        }
    }

    private fun setCollectorsAssets(){
        binding.collectorsBtn.setOnClickListener(){
            navigateToCollectors()
        }
    }

    private fun navigateToAlbums(){
        val intent = Intent(this, AlbumList::class.java)
        startActivity(intent)
    }

    private fun navigateToArtists(){
        val intent = Intent(this, ArtistList::class.java)
        startActivity(intent)
    }

    private fun navigateToCollectors(){
        val intent = Intent(this, CollectorList::class.java)
        startActivity(intent)
    }
}