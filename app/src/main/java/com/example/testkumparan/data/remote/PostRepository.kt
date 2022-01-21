package com.example.testkumparan.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testkumparan.data.entity.CommentEntity
import com.example.testkumparan.data.entity.DetailPostEntity
import com.example.testkumparan.data.entity.PostEntity
import com.example.testkumparan.data.entity.UserEntity
import com.example.testkumparan.data.response.CommentResponseItem
import com.example.testkumparan.data.response.PostResponseItem

class PostRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    PostDataSource {
    companion object {
        @Volatile
        private var instance: PostRepository? = null

        fun getInstance(remoteData: RemoteDataSource): PostRepository =
            instance ?: synchronized(this) {
                instance ?: PostRepository(remoteData)
            }
    }

    override fun getPosts(): LiveData<List<PostEntity>> {
        val postItems = MutableLiveData<List<PostEntity>>()

        remoteDataSource.getPosts(object : RemoteDataSource.LoadPostsCallback {
            override fun onPostsLoaded(posts: List<PostResponseItem>?) {
                val postList = ArrayList<PostEntity>()
                if (posts != null) {
                    for (response in posts) {
                        with(response) {
                            val post = PostEntity(id, title, body, userId)
                            postList.add(post)
                        }
                    }
                    postItems.postValue(postList)
                }
            }
        })
        return postItems
    }

    override fun getUsers(postId: Int): LiveData<List<UserEntity>> {
        TODO("Not yet implemented")
    }

    override fun getDetailPost(id: Int): LiveData<DetailPostEntity> {
        val postDetailItems = MutableLiveData<DetailPostEntity>()

        remoteDataSource.getDetailPost(object : RemoteDataSource.LoadDetailPostCallback {
            override fun onDetailPostLoaded(postDetail: PostResponseItem?) {
                if (postDetail != null) {
                    with(postDetail) {
                        val detailPost = DetailPostEntity(
                            id = id,
                            userId = userId,
                            title = title,
                            body = body
                        )
                        postDetailItems.postValue(detailPost)
                    }
                }
            }
        }, id)
        return postDetailItems
    }

    override fun getComments(postId: Int): LiveData<List<CommentEntity>> {
        val commentItems = MutableLiveData<List<CommentEntity>>()

        remoteDataSource.getComments(object : RemoteDataSource.LoadCommentsCallback {
            override fun onCommentsLoaded(comments: List<CommentResponseItem>?) {
                val movieCastList = ArrayList<CommentEntity>()
                if (comments != null) {
                    for (response in comments) {
                        with(response) {
                            val movieCast = CommentEntity(id, postId, name, body)
                            movieCastList.add(movieCast)
                        }
                    }
                    commentItems.postValue(movieCastList)
                }
            }
        }, postId)
        return commentItems
    }
}