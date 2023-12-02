package com.example.vinilosapp.ui.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosapp.data.model.Track
import com.example.vinilosapp.databinding.ItemTrackBinding

class AlbumTrackViewholder (val binding: ItemTrackBinding):RecyclerView.ViewHolder(binding.root)   {

    fun render(trackModel: Track){
        binding.tvName.text = trackModel.name
        binding.tvDuration.text = trackModel.duration
    }

}