package com.example.vinilosapp.ui.view.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vinilosapp.R
import com.example.vinilosapp.data.model.Collector
import com.example.vinilosapp.databinding.ItemCollectorBinding

class CollectorViewholder (view: View):RecyclerView.ViewHolder(view)   {

    private val binding = ItemCollectorBinding.bind(view)

    fun render(collectormodel: Collector){

        binding.tvName.text = collectormodel.name
        binding.tvTelephone.text = collectormodel.telephone
        binding.tvEmail.text = collectormodel.email

    }

}