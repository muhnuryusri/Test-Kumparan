package com.example.testkumparan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testkumparan.data.response.PostResponseItem
import com.example.testkumparan.data.response.UserResponseItem
import com.example.testkumparan.databinding.ItemPostBinding

class UserAdapter(private val listUser: List<UserResponseItem>?) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private val users = ArrayList<PostResponseItem>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        listUser?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = listUser?.size?: 0

    inner class ViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserResponseItem?) {
            with(binding) {
                tvUsername.text = user?.username
                tvCompany.text = user?.company?.name
            }
        }
    }
}