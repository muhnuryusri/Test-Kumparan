package com.example.testkumparan.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testkumparan.data.remote.PostRepository

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {
    fun getPostList() = postRepository.getPosts()
}