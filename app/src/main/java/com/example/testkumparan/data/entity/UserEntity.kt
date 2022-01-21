package com.example.testkumparan.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserEntity(
    val id: Int?,
    val username: String?,
    val body: String?,
    val userId: Int?,
) : Parcelable