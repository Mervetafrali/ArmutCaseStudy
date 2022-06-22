package com.mt.armutcasestudy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mt.armutcasestudy.databinding.PopularLayoutAdapterBinding
import com.mt.armutcasestudy.databinding.ServiceLayoutAdapterBinding
import com.mt.armutcasestudy.model.Popular

import com.mt.armutcasestudy.model.ServiceItem

class PopularAdapter: RecyclerView.Adapter<PopularAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: PopularLayoutAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)


    private val diffCallback = object : DiffUtil.ItemCallback<Popular>() {
        override fun areItemsTheSame(oldItem: Popular, newItem: Popular): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Popular, newItem: Popular): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var popular: List<Popular>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            PopularLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentService = popular[position]

        holder.binding.apply {
            itemName.text = currentService.name

            itemImg.load(currentService.image_url) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount() = popular.size

}
