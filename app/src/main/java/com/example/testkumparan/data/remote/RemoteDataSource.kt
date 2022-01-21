package com.example.testkumparan.data.remote

import android.util.Log
import com.example.testkumparan.data.api.ApiConfig
import com.example.testkumparan.data.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    fun getPosts(callback: LoadPostsCallback) {
        val client = ApiConfig.getApiService().getPosts()
        client.enqueue(object : Callback<PostResponse> {
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                callback.onPostsLoaded(response.body()?.postResponse as List<PostResponseItem>?)
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getPosts onFailure : ${t.message}")
            }
        })
    }

    fun getDetailPost(callback: LoadDetailPostCallback, id: Int) {
        val client = ApiConfig.getApiService().getPostDetail(id)
        client.enqueue(object : Callback<PostResponseItem> {
            override fun onResponse(call: Call<PostResponseItem>, response: Response<PostResponseItem>) {
                callback.onDetailPostLoaded(response.body())
            }

            override fun onFailure(call: Call<PostResponseItem>, t: Throwable) {
                Log.e("RemoteDataSource", "getMovieDetail onFailure : ${t.message}")
            }
        })
    }

    fun getComments(callback: LoadCommentsCallback, id: Int) {
        val client = ApiConfig.getApiService().getComments(id)
        client.enqueue(object : Callback<CommentResponse> {
            override fun onResponse(call: Call<CommentResponse>, response: Response<CommentResponse>) {
                callback.onCommentsLoaded(response.body()?.commentResponse as List<CommentResponseItem>?)
            }

            override fun onFailure(call: Call<CommentResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getMovieDetail onFailure : ${t.message}")
            }
        })
    }

    interface LoadPostsCallback {
        fun onPostsLoaded(posts : List<PostResponseItem>?)
    }

    interface LoadUsersCallback {
        fun onUsersLoaded(users : List<UserResponseItem>?)
    }

    interface LoadDetailPostCallback {
        fun onDetailPostLoaded(postDetail : PostResponseItem?)
    }

    interface LoadCommentsCallback {
        fun onCommentsLoaded(comments : List<CommentResponseItem>?)
    }
}