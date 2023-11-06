package com.example.vinilosapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosapp.Album
import com.example.vinilosapp.R

class albumadapter (private val albumList:List<Album>): RecyclerView.Adapter<Albumviewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Albumviewholder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Albumviewholder(layoutInflater.inflate(R.layout.item_album,parent,false))
    }

    override fun getItemCount(): Int = albumList.size


    override fun onBindViewHolder(holder: Albumviewholder, position: Int) {
        val item = albumList[position]
        holder.render(item)
    }

}


