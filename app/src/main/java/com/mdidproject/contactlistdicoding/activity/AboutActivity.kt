package com.mdidproject.contactlistdicoding.activity

import android.os.Binder
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mdidproject.contactlistdicoding.R
import com.mdidproject.contactlistdicoding.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_about)
        Glide.with(this@AboutActivity)
            .load(R.drawable.about)
            .apply(RequestOptions().override(150, 150))
            .into(binding.ivAbout)
    }
}