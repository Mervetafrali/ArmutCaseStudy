package com.mt.armutcasestudy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mt.armutcasestudy.databinding.ServiceLayoutAdapterBinding
import com.mt.armutcasestudy.model.ServiceItem

class ServiceAdapter: RecyclerView.Adapter<ServiceAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ServiceLayoutAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)


    private val diffCallback = object : DiffUtil.ItemCallback<ServiceItem>() {
        override fun areItemsTheSame(oldItem: ServiceItem, newItem: ServiceItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ServiceItem, newItem: ServiceItem): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var services: List<ServiceItem>
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
        val currentService = services[position]

        holder.binding.apply {
            itemName.text = currentService.name

            itemImg.load(currentService.image_url) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount() = services.size

}
