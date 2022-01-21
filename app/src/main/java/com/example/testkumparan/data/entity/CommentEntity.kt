package com.example.testkumparan.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CommentEntity(
    val id: Int?,
    val postId: Int?,
    val name: String?,
    val body: String?
) : Parcelable