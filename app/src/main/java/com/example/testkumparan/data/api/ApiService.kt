package com.example.testkumparan.data.api

import com.example.testkumparan.data.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<PostResponse>

    @GET("posts/{id}")
    fun getPostDetail(
        @Path("id") id: Int
    ): Call<PostResponseItem>

    @GET("posts/{postId}/comments")
    fun getComments(
        @Path("postId") postId: Int
    ): Call<CommentResponse>

    @GET("users/{id}")
    fun getUserDetail(
        @Path("id") id: Int
    ): Call<UserResponse>

    @GET("albums")
    fun getAlbums(): Call<AlbumResponse>

    @GET("photos")
    fun getPhotos(): Call<PhotoResponse>

    @GET("photos/{id}")
    fun getPhotoDetail(
        @Path("id") id: Int
    ): Call<PhotoResponse>
}