package com.example.vinilosapp.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosapp.R
import com.example.vinilosapp.data.model.Album

class AlbumAdapter (private var albumList:List<Album>? = emptyList()): RecyclerView.Adapter<AlbumViewholder>(){

    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    fun updateList(albumList: List<Album>?){
        this.albumList=albumList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewholder {
        return AlbumViewholder(LayoutInflater.from(parent.context).inflate(R.layout.item_album,parent,false))
    }

    override fun getItemCount(): Int = albumList?.size ?:0


    override fun onBindViewHolder(holder: AlbumViewholder, position: Int) {

        (albumList?.get(position) ?:null)?.let { holder.render(it) }

        // Set click listener in onBindViewHolder
        holder.itemView.setOnClickListener {
            val albumId = albumList?.get(position)?.id
            if (albumId != null) {
                onItemClickListener?.onItemClick(albumId)
            }
        }
    }


    interface OnItemClickListener {
        fun onItemClick(albumId: String?) // Change the type of ID according to your Album model
    }
}


