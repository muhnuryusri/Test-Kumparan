package com.example.testkumparan.data

import com.example.testkumparan.data.entity.CommentEntity
import com.example.testkumparan.data.entity.PostEntity

interface DataCallback {
    fun onPostClicked(data: PostEntity)
    fun onCommentClicked(comment: CommentEntity)
}