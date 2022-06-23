package com.mdidproject.contactlistdicoding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Looper
import com.mdidproject.contactlistdicoding.activity.ContactListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainActivity, ContactListActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}