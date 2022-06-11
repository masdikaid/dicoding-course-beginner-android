package com.mdidproject.contactlistdicoding.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mdidproject.contactlistdicoding.`interface`.ItemAdapterCallback
import com.mdidproject.contactlistdicoding.data.Contact
import com.mdidproject.contactlistdicoding.databinding.ContactItemBinding

class ContactListAdapter(private val contacData: ArrayList<Contact>): RecyclerView.Adapter<ContactListAdapter.ListViewHolder>() {
    private lateinit var cardCallback: ItemAdapterCallback<Contact>
    private lateinit var callCallback: ItemAdapterCallback<Contact>

    class ListViewHolder(var binding: ContactItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(vg: ViewGroup, i: Int): ListViewHolder {
        val binding = ContactItemBinding.inflate(LayoutInflater.from(vg.context), vg, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(lv: ListViewHolder, i: Int) {
        val (contactname, pnumber, _, image) = contacData[i]
        lv.binding.apply {
            Glide.with(lv.itemView.context)
                .load(image)
                .apply(RequestOptions().override(70, 70))
                .into(avatar)

            contactName.text = contactname
            phoneNumber.text = pnumber
            callButton.setOnClickListener { callCallback.onItemClicked(contacData[lv.adapterPosition]) }
        }
        lv.itemView.setOnClickListener{ cardCallback.onItemClicked(contacData[lv.adapterPosition]) }
    }

    override fun getItemCount(): Int = contacData.size

    fun setAdapterItemCallback(cardCb: ItemAdapterCallback<Contact>, callCb: ItemAdapterCallback<Contact>) {
        cardCallback = cardCb
        callCallback = callCb
    }
}