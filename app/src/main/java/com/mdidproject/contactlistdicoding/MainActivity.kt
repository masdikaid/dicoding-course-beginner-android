package com.mdidproject.contactlistdicoding

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.os.Handler
import android.os.Looper
import com.mdidproject.contactlistdicoding.activity.ContactListActivity
import com.mdidproject.contactlistdicoding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainActivity, ContactListActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}