package com.example.testkumparan.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testkumparan.DetailPostActivity
import com.example.testkumparan.data.DataCallback
import com.example.testkumparan.data.entity.PostEntity
import com.example.testkumparan.data.response.PostResponseItem
import com.example.testkumparan.databinding.ItemPostBinding

class PostAdapter(private val callback: DataCallback) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    private val listPost = ArrayList<PostEntity>()

    fun setData(data: List<PostEntity>) {
        listPost.clear()
        listPost.addAll(data)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        listPost.get(position).let { holder.bind(it) }
    }

    override fun getItemCount(): Int = listPost.size

    inner class ViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: PostEntity?) {
            with(binding) {
                tvTitle.text = post?.title
                tvBody.text = post?.body
                itemView.setOnClickListener {
                    if (post != null) {
                        callback.onPostClicked(post)
                    }
                }
            }
        }
    }
}