package com.mdidproject.contactlistdicoding.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mdidproject.contactlistdicoding.data.Contact
import com.mdidproject.contactlistdicoding.databinding.ActivityDetailContactBinding

class DetailContactActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contactData = intent.getParcelableExtra<Contact>("contactData")
        binding = ActivityDetailContactBinding.inflate(layoutInflater)

        contactData?.let { dt ->
            title = contactData.name
            binding.apply {
                Glide.with(this@DetailContactActivity)
                    .load(dt.avatar)
                    .apply(RequestOptions().override(70, 70))
                    .circleCrop()
                    .into(ivAvatar)

                tvName.text = dt.name
                tvNumber.text = dt.number
                tvEmail.text = dt.email

                imbCall.setOnClickListener {
                    val dial = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${dt.number}"))
                    startActivity(dial)
                }

                imbShare.setOnClickListener {
                    val intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        type = "text/plain"
                        putExtra(Intent.EXTRA_SUBJECT, "Hey Save ${dt.name} Contact !")
                        putExtra(Intent.EXTRA_TEXT, "Hey save that our friends ${dt.name} Contact ! \n${dt.number}")
                    }

                    startActivity(Intent.createChooser(intent, "Share link!"))
                }
            }
        } ?: run {
            Toast.makeText(this@DetailContactActivity, "failed to load contact data", Toast.LENGTH_SHORT).show()
        }

        setContentView(binding.root)

    }
}