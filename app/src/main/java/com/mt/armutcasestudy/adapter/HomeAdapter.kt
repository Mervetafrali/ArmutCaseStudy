package com.mt.armutcasestudy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mt.armutcasestudy.databinding.ServiceLayoutAdapterBinding
import com.mt.armutcasestudy.model.Home

import com.mt.armutcasestudy.model.ServiceItem

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ServiceLayoutAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)


    private val diffCallback = object : DiffUtil.ItemCallback<Home>() {
        override fun areItemsTheSame(oldItem: Home, newItem: Home): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Home, newItem: Home): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var home: List<Home>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ServiceLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentService = home[position]

       /* holder.binding.apply {
            itemName.text = currentService.name

            itemImg.load(currentService.image_url) {
                crossfade(true)
                crossfade(1000)
            }
        }*/
    }

    override fun getItemCount() = home.size

}
