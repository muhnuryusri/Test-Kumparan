package com.example.testkumparan.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testkumparan.DetailPostActivity
import com.example.testkumparan.data.DataCallback
import com.example.testkumparan.data.entity.CommentEntity
import com.example.testkumparan.data.entity.PostEntity
import com.example.testkumparan.data.response.PostResponseItem
import com.example.testkumparan.databinding.ItemCommentBinding
import com.example.testkumparan.databinding.ItemPostBinding

class CommentAdapter(private val callback: DataCallback) : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    private val listComment = ArrayList<CommentEntity>()

    fun setData(data: List<CommentEntity>) {
        listComment.clear()
        listComment.addAll(data)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CommentAdapter.ViewHolder {
        val binding = ItemCommentBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        listComment.get(position).let { holder.bind(it) }
    }

    override fun getItemCount(): Int = listComment.size

    inner class ViewHolder(private val binding: ItemCommentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(comment: CommentEntity?) {
            with(binding) {
                tvUsername.text = comment?.name
                tvComment.text = comment?.body
                itemView.setOnClickListener {
                    if (comment != null) {
                        callback.onCommentClicked(comment)
                    }
                }
            }
        }
    }
}