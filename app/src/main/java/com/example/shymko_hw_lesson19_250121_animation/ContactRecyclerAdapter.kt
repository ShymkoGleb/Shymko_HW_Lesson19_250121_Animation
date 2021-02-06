package com.example.shymko_hw_lesson19_250121_animation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shymko_hw_lesson19_250121_animation.databinding.ContatRecyclerViewBinding

class ContactRecyclerAdapter(private val block: (TextView, TextView, ImageView, Contact) -> Unit) :
    RecyclerView.Adapter<ContactRecyclerAdapter.ViewHolder>() {

    var contactList: List<Contact> = emptyList()

    fun setContact(newItems: List<Contact>) {
        contactList = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contat_recycler_view, parent, false)
        return ViewHolder(view, block)
    }

    override fun getItemCount(): Int = contactList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactList[position])
    }

    class ViewHolder(itemView: View, val bloc: (TextView, TextView, ImageView, Contact) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private var binding = ContatRecyclerViewBinding.bind(itemView)
        fun bind(contact: Contact) {
            binding.tvContactName.text = contact.name
            binding.tvContactPhone.text = contact.number
            Glide.with(itemView)
                .load(contact.imgId)
                .centerCrop()
                .into(binding.ivContactIcon)
            itemView.setOnClickListener {
                bloc(binding.tvContactName, binding.tvContactName, binding.ivContactIcon, contact)
            }
        }
    }
}