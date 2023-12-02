package com.example.vinilosapp.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosapp.R
import com.example.vinilosapp.data.model.Album
import com.example.vinilosapp.data.model.Track
import com.example.vinilosapp.databinding.ItemTrackBinding

class AlbumTrackAdapter (private var trackList:List<Track>? = emptyList()): RecyclerView.Adapter<AlbumTrackViewholder>(){

    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    fun updateList(trackList: List<Track>?){
        this.trackList=trackList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumTrackViewholder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTrackBinding.inflate(inflater,parent, false)
        return AlbumTrackViewholder(binding)
    }

    override fun getItemCount(): Int = trackList?.size ?:0


    override fun onBindViewHolder(holder: AlbumTrackViewholder, position: Int) {

        (trackList?.get(position) ?:null)?.let { holder.render(it) }

        // Set click listener in onBindViewHolder
        holder.itemView.setOnClickListener {
            val albumId = trackList?.get(position)?.id
            if (albumId != null) {
                onItemClickListener?.onItemClick(albumId)
            }
        }
    }


    interface OnItemClickListener {
        fun onItemClick(albumId: Double) // Change the type of ID according to your Album model
    }
}


