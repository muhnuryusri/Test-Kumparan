package com.example.testkumparan.data.response

import com.google.gson.annotations.SerializedName

data class AlbumResponse(

	@field:SerializedName("AlbumResponse")
	val albumsResponse: List<AlbumResponseItem?>? = null
)

data class AlbumResponseItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
)
