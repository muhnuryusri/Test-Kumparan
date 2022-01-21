package com.example.testkumparan.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailPostEntity(
    val id: Int?,
    val userId: Int?,
    val title: String?,
    val body: String?,
) : Parcelable