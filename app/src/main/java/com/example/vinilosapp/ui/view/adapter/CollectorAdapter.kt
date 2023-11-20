package com.example.vinilosapp.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilosapp.R
import com.example.vinilosapp.data.model.Collector

class CollectorAdapter (private var collectorList:List<Collector>? = emptyList()): RecyclerView.Adapter<CollectorViewholder>(){

    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    fun updateList(collectorList: List<Collector>?){
        this.collectorList=collectorList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectorViewholder {
        return CollectorViewholder(LayoutInflater.from(parent.context).inflate(R.layout.item_collector,parent,false))
    }

    override fun getItemCount(): Int = collectorList?.size ?:0


    override fun onBindViewHolder(holder: CollectorViewholder, position: Int) {
        (collectorList?.get(position) ?:null)?.let { holder.render(it) }

        // Set click listener in onBindViewHolder
        holder.itemView.setOnClickListener {
            val collectorId = collectorList?.get(position)?.id
            if (collectorId != null) {
                onItemClickListener?.onItemClick(collectorId.toInt())
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(albumId: Int) // Change the type of ID according to your Album model
    }
}


