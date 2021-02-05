package com.example.shymko_hw_lesson19_250121_animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.shymko_hw_lesson19_250121_animation.databinding.ContactActivityBinding

const val CONTACT = "Contact"

class ContactActivity : AppCompatActivity() {

    private lateinit var binding: ContactActivityBinding

    private lateinit var contact: Contact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        contact = intent?.extras?.getParcelable(CONTACT) ?: Contact(
            "Name",
            "+380 000 000 00",
            R.drawable.ic_launcher_foreground
        )
        setupBinding()
        setupViews()
    }

    private fun setupBinding() {
        binding = ContactActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupViews() {
        binding.tvContactName1.text = contact.name
        binding.tvContactPhone1.text = contact.number
        Glide.with(this)
            .load(contact.imgId)
            .into(binding.ivContactIcon)
    }
}