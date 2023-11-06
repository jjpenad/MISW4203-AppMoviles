package com.example.vinilosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosapp.ui.view.adapter.AlbumAdapter

class Catalogoalbumes : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AlbumProvider.AlbumList
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerAlbum)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AlbumAdapter(AlbumProvider.AlbumList)
    }
}