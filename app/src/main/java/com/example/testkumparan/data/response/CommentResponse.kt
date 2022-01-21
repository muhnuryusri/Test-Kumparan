package com.example.testkumparan.data.response

import com.google.gson.annotations.SerializedName

data class CommentResponse(

	@field:SerializedName("CommentResponse")
	val commentResponse: List<CommentResponseItem?>? = null
)

data class CommentResponseItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("postId")
	val postId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
