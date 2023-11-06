package com.example.vinilosapp.ui.view.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosapp.R
import com.example.vinilosapp.data.model.Album
import com.example.vinilosapp.databinding.ItemAlbumBinding

class AlbumViewholder (view: View):RecyclerView.ViewHolder(view)   {

    private val binding = ItemAlbumBinding.bind(view)

    fun render(albummodel: Album){

        binding.tvnombre.text = albummodel.name

    }

}