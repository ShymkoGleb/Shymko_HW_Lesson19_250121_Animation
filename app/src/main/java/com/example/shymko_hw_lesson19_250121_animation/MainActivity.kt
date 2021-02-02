package com.example.shymko_hw_lesson19_250121_animation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Contact.contactList.add(Contact("Gleb0","+38 067 000 00 00"))
        Contact.contactList.add(Contact("Nestor1","+38 067 111 11 11"))
        Contact.contactList.add(Contact("Gleb2","+38 067 222 22 22"))
        Contact.contactList.add(Contact("Nestor3","+38 067 333 33 32"))
        Contact.contactList.add(Contact("Gleb4","+38 067 444 44 44"))
        Contact.contactList.add(Contact("Nestor5","+38 067 555 55 55"))
        Contact.contactList.add(Contact("Gleb6","+38 067 666 66 66"))
        Contact.contactList.add(Contact("Nestor7","+38 067 777 77 77"))
        Contact.contactList.add(Contact("Gleb8","+38 067 888 88 88"))
        Contact.contactList.add(Contact("Nestor9","+38 067 999 99 99"))
        var adapter = RecyclerAdapter(Contact.contactList)
        rvRecyclterViewContact.adapter=adapter
    rvRecyclterViewContact.layoutManager = LinearLayoutManager(this)
        adapter.notifyItemInserted(Contact.contactList.size - 1)

        runLayoutAnimation(adapter)

    }


    private fun runLayoutAnimation( recyclerView:RecyclerAdapter) {
         val context  = rvRecyclterViewContact.getContext()
         val controller =
            AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)

        rvRecyclterViewContact.layoutAnimation = controller
        rvRecyclterViewContact.adapter?.notifyDataSetChanged()
        rvRecyclterViewContact.scheduleLayoutAnimation()
    }
}