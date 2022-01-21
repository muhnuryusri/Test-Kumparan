package com.example.testkumparan.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testkumparan.data.remote.PostRepository

class CommentViewModel(private val postRepository: PostRepository) : ViewModel() {
    fun getListComment(id: Int) = postRepository.getComments(id)
}