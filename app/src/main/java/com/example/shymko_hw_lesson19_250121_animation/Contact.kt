package com.example.shymko_hw_lesson19_250121_animation

import android.widget.ImageView

class Contact(
  // val image: ImageView,
    val name: String,
    val nubmer: String
) {
    companion object {
        val contactList = mutableListOf<Contact>()

    }
}