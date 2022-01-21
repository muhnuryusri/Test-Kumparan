package com.example.testkumparan.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.testkumparan.data.entity.DetailPostEntity
import com.example.testkumparan.data.remote.PostRepository

class DetailPostViewModel(private val postRepository: PostRepository) : ViewModel() {
    fun getSelectedPost(id: Int): LiveData<DetailPostEntity> = postRepository.getDetailPost(id)
}