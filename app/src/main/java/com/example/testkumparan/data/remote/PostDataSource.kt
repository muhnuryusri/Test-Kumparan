package com.example.testkumparan.data.remote

import androidx.lifecycle.LiveData
import com.example.testkumparan.data.entity.CommentEntity
import com.example.testkumparan.data.entity.DetailPostEntity
import com.example.testkumparan.data.entity.PostEntity
import com.example.testkumparan.data.entity.UserEntity

interface PostDataSource {
    fun getPosts(): LiveData<List<PostEntity>>
    fun getUsers(postId: Int): LiveData<List<UserEntity>>
    fun getDetailPost(id: Int): LiveData<DetailPostEntity>
    fun getComments(postId: Int): LiveData<List<CommentEntity>>
}