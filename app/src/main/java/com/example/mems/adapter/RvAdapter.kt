package com.example.mems.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mems.databinding.ActivityMainBinding
import com.example.mems.databinding.MemitemBinding
import com.example.mems.models.Meme
import com.squareup.picasso.Picasso

class RvAdapter (private  val Memes:List<Meme>):RecyclerView.Adapter<RvAdapter.ViewHolder>(){
    class ViewHolder(val binding: MemitemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = Memes[position]

        holder.binding.apply {
            Picasso.get().load(currentItem.url).into(ImgMem)
            nameMem.text = currentItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(MemitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return  Memes.size
    }
}