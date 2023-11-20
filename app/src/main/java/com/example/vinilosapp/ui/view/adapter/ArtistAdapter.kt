package com.example.vinilosapp.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosapp.R
import com.example.vinilosapp.data.model.Artist

class ArtistAdapter (private var artistList:List<Artist>? = emptyList()): RecyclerView.Adapter<ArtistViewholder>(){

    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    fun updateList(artistList: List<Artist>?){
        this.artistList=artistList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewholder {
        return ArtistViewholder(LayoutInflater.from(parent.context).inflate(R.layout.item_artist,parent,false))
    }

    override fun getItemCount(): Int = artistList?.size ?:0


    override fun onBindViewHolder(holder: ArtistViewholder, position: Int) {
        (artistList?.get(position) ?:null)?.let { holder.render(it) }

        // Set click listener in onBindViewHolder
        holder.itemView.setOnClickListener {
            val artistId = artistList?.get(position)?.id
            if (artistId != null) {
                onItemClickListener?.onItemClick(artistId.toInt())
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(albumId: Int) // Change the type of ID according to your Album model

    }

}


