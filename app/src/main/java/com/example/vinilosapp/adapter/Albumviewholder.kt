package com.example.vinilosapp.adapter

import android.view.View
import android.widget.TextView
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosapp.Album
import com.example.vinilosapp.R

class Albumviewholder (view: View):RecyclerView.ViewHolder(view)   {

    val nombre = view.findViewById<TextView>(R.id.tvnombre)
    val foto = view.findViewById<TextView>(R.id.tvfoto)
    val foto_album = view.findViewById<TextView>(R.id.ivAlbum)

    fun render(albummodel: Album){
        nombre.text = albummodel.nombre
        foto.text = albummodel.foto



    }

}