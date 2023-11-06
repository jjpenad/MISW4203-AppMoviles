package com.example.vinilosapp.ui.view.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vinilosapp.R
import com.example.vinilosapp.data.model.Album
import com.example.vinilosapp.databinding.ItemAlbumBinding

class AlbumViewholder (view: View):RecyclerView.ViewHolder(view)   {

    private val binding = ItemAlbumBinding.bind(view)

    fun render(albummodel: Album){

        binding.tvName.text = albummodel.name
        binding.tvDescription.text = albummodel.description
        Glide.with(binding.imageView.context).load(albummodel.cover).into(binding.imageView)

    }

}