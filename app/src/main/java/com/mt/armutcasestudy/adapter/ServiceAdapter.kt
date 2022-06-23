package com.mt.armutcasestudy.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.mt.armutcasestudy.databinding.ServiceLayoutAdapterBinding
import com.mt.armutcasestudy.model.AllService
import com.mt.armutcasestudy.DetailsActivity


class ServiceAdapter(var mContext: Context, var serviceTitles: Array<String>, var serviceImages: Array<String>) : RecyclerView.Adapter<ServiceAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ServiceLayoutAdapterBinding) :
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
            ServiceLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=services[position]
        val activity = holder.itemView.context as Activity
        val intent = Intent(activity, DetailsActivity::class.java)
        val currentServiceImage = serviceImages[position]
        val currentServiceTitles = serviceTitles[position]
        holder.binding.apply {
            serviceItemText.text = currentServiceTitles
            serviceItemImage.setImageResource(root.resources.getIdentifier(currentServiceImage,"drawable",root.context.packageName))
        }
        val gson = Gson()
        holder.itemView.setOnClickListener{mView->
           Log.i("deneme",currentItem.toString())
            intent.putExtra("service", gson.toJson(currentItem))
            mContext.startActivity(intent)
        }

    }

    override fun getItemCount() = services.size

}
