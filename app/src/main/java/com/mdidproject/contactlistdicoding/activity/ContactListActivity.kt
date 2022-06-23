package com.mdidproject.contactlistdicoding.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.mdidproject.contactlistdicoding.R
import com.mdidproject.contactlistdicoding.`interface`.ItemAdapterCallback
import com.mdidproject.contactlistdicoding.adapter.ContactListAdapter
import com.mdidproject.contactlistdicoding.data.Contact
import com.mdidproject.contactlistdicoding.data.ContactList
import com.mdidproject.contactlistdicoding.databinding.ActivityContactListBinding

class ContactListActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showContactList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.about_menu -> {
                val intent = Intent(this@ContactListActivity, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return true
        }
    }

    private fun showContactList(){
        val listAdapter = ContactListAdapter(ContactList.getData)

        listAdapter.setAdapterItemCallback(
            object: ItemAdapterCallback<Contact>{
                override fun onItemClicked(Data: Contact) {
                    val intent = Intent(this@ContactListActivity, DetailContactActivity::class.java)
                    intent.putExtra("contactData", Data)
                    startActivity(intent)
                }

            },
            object: ItemAdapterCallback<Contact>{
                override fun onItemClicked(Data: Contact) {
                    val dial = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${Data.number}"))
                    startActivity(dial)
                }

            }
        )

        binding.rvContact.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ContactListActivity)
            adapter = listAdapter
        }
    }
}