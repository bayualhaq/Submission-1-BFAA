package com.bayu.submission1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val avatar: Int,
    val name: String,
    val username: String,
    val location: String,
    val company: String,
    val repository: String,
    val followers: String,
    val following: String
) : Parcelable