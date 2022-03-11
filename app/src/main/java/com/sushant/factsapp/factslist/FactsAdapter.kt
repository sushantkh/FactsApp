package com.sushant.factsapp.factslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sushant.factsapp.databinding.FactRowBinding
import com.sushant.factsapp.models.Rows

class FactsAdapter(val list: List<Rows>) : RecyclerView.Adapter<FactsAdapter.PostViewHolder>() {

    inner class PostViewHolder(val binding: FactRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = FactRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        with(holder)
        {
            with(list[position])
            {
                binding.tvTitle.text=this.title
                binding.tvDecription.text=this.description
                binding.imageView.load(this.imageHref)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}