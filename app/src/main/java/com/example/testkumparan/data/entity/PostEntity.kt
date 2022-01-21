package com.example.testkumparan.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostEntity(
    val id: Int?,
    val title: String?,
    val body: String?,
    val userId: Int?
) : Parcelable