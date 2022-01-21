package com.example.testkumparan.data.response

import com.google.gson.annotations.SerializedName

data class PhotoResponse(

	@field:SerializedName("PhotoResponse")
	val photosResponse: List<PhotoResponseItem?>? = null
)

data class PhotoResponseItem(

	@field:SerializedName("albumId")
	val albumId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("thumbnailUrl")
	val thumbnailUrl: String? = null
)
