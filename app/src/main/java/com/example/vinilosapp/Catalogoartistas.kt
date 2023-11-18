package com.example.vinilosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosapp.ui.view.adapter.AlbumAdapter

class Catalogoartistas : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ArtistProvider.ArtistList
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerArtist)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AlbumAdapter(ArtistProvider.ArtistList)
    }
}