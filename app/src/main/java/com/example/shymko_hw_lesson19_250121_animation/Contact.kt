package com.example.shymko_hw_lesson19_250121_animation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    val name: String,
    val number: String,
    val imgId: Int
) : Parcelable