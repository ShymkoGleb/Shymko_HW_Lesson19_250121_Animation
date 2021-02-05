package com.example.shymko_hw_lesson19_250121_animation


import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.toAndroidPair
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shymko_hw_lesson19_250121_animation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var contactAdapter: ContactRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contactList = listOf(
            Contact("Gleb0", "+38 067 000 00 00", R.drawable.ic_baseline_face_24),
            Contact("Nestor1", "+38 067 111 11 11", R.drawable.ic_baseline_cake_24),
            Contact("Gleb2", "+38 067 222 22 22", R.drawable.ic_baseline_face_24),
            Contact("Nestor3", "+38 067 333 33 32", R.drawable.ic_baseline_cake_24),
            Contact("Gleb4", "+38 067 444 44 44", R.drawable.ic_baseline_face_24),
            Contact("Nestor5", "+38 067 555 55 55", R.drawable.ic_baseline_cake_24),
            Contact("Gleb6", "+38 067 666 66 66", R.drawable.ic_baseline_face_24),
            Contact("Nestor7", "+38 067 777 77 77", R.drawable.ic_baseline_cake_24),
            Contact("Gleb8", "+38 067 888 88 88", R.drawable.ic_baseline_face_24),
            Contact("Nestor9", "+38 067 999 99 99", R.drawable.ic_baseline_cake_24)
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contactAdapter = ContactRecyclerAdapter { tvName, tvPhone, ivIcon, contact ->

            val intent = Intent(this, ContactActivity::class.java).apply {
                putExtra(CONTACT, contact)
            }
            val pairImage =
                Pair<View, String>(ivIcon, getString(R.string.icon_transition)).toAndroidPair()
            val pairName =
                Pair<View, String>(tvName, getString(R.string.name_transition)).toAndroidPair()
            val pairPhone =
                Pair<View, String>(tvPhone, getString(R.string.phone_transition)).toAndroidPair()
            val activityOptions =
                ActivityOptions.makeSceneTransitionAnimation(this, pairImage, pairName, pairPhone)
            startActivity(intent, activityOptions.toBundle())
        }
        contactAdapter.setContact(contactList)

        binding.rvContact.apply {
            adapter = contactAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                RecyclerView.VERTICAL,
                false
            )
            addItemDecoration(
                DividerItemDecoration(this@MainActivity, RecyclerView.VERTICAL)
            )
        }

    }

}

