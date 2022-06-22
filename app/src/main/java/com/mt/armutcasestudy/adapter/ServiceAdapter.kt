package com.mt.armutcasestudy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mt.armutcasestudy.R
import com.mt.armutcasestudy.databinding.ServiceItemBinding
import com.mt.armutcasestudy.model.AllService


class ServiceAdapter(var serviceTitles: Array<String>, var serviceImages: Array<String>) : RecyclerView.Adapter<ServiceAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ServiceItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    private val diffCallback = object : DiffUtil.ItemCallback<AllService>() {
        override fun areItemsTheSame(oldItem: AllService, newItem: AllService): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AllService, newItem: AllService): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var services: List<AllService>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ServiceItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentServiceImage = serviceImages[position]
        val currentServiceTitles = serviceTitles[position]
        holder.binding.apply {
            serviceItemText.text = currentServiceTitles
            serviceItemImage.setImageResource(root.resources.getIdentifier(currentServiceImage,"drawable",root.context.packageName))
        }
    }

    override fun getItemCount() = services.size

}
