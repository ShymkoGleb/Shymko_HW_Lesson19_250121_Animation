package com.example.shymko_hw_lesson19_250121_animation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycle_layout.view.*

class RecyclerAdapter(
    var contactList: MutableList<Contact>
) : RecyclerView.Adapter<RecyclerAdapter.PersonViewHolder>() {
    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_layout, parent, false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.itemView.apply {
          //  tvContactImage.imageAlpha = contactList[position].toString().toInt()
            tvContactName.text = contactList[position].name.toString()
            tvContactNubmer.text = contactList[position].nubmer.toString()
        }
    }
}