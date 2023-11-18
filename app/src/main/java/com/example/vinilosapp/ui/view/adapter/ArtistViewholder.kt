package com.example.vinilosapp.ui.view.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vinilosapp.R
import com.example.vinilosapp.data.model.Album
import com.example.vinilosapp.data.model.Artist
import com.example.vinilosapp.databinding.ItemAlbumBinding
import com.example.vinilosapp.databinding.ItemArtistBinding

class ArtistViewholder (view: View):RecyclerView.ViewHolder(view)   {

    private val binding = ItemArtistBinding.bind(view)

    fun render(artistmodel: Artist){

        binding.tvName.text = artistmodel.name
        binding.tvDescription.text = artistmodel.description
        Glide.with(binding.imageView.context).load(artistmodel.cover).into(binding.imageView)

    }

}