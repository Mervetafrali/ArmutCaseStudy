package com.mt.armutcasestudy.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mt.armutcasestudy.databinding.PostsLayoutAdapterBinding
import com.mt.armutcasestudy.model.Post


class PostsAdapter: RecyclerView.Adapter<PostsAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: PostsLayoutAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)


    private val diffCallback = object : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var posts: List<Post>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            PostsLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPost = posts[position]

        holder.binding.apply {
            itemName.text = currentPost.title

            itemImg.load(currentPost.image_url) {
                crossfade(true)
                crossfade(1000)
            }
        }
       /* holder.itemView.setOnClickListener {
           // val direction = FragmentN

            intent = Intent(this@PostsAdapter, ListViewImage::class.java)
            startActivity(intent)
            finish()
        }*/
    }

    override fun getItemCount() = posts.size

}
