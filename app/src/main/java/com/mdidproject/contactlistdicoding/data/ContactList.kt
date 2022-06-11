package com.mdidproject.contactlistdicoding.data

import com.mdidproject.contactlistdicoding.R

object ContactList {
    val name = arrayOf(
        "Dika Adi Setiawan",
        "Andre Ahmad",
        "Hendro Dirdjanto",
        "Yeyen Ambarwati",
        "Kila Armayanti",
        "Birol Setiawan",
        "Imam Dirgantara",
        "Indra Bakri",
        "Irvan Maulana",
        "Ipul Suganda",
    )

    val number = arrayOf(
        "085771002550",
        "085771002551",
        "085771002552",
        "085771002553",
        "085771002554",
        "085771002555",
        "085771002556",
        "085771002557",
        "085771002558",
        "085771002559",
    )

    val email = arrayOf(
        "masdikaid@gmail.com",
        "andre@gmail.com",
        "hendro@gmail.com",
        "yeyen@gmail.com",
        "kila@gmail.com",
        "birol@gmail.com",
        "imam@gmail.com",
        "indra@gmail.com",
        "irvan@gmail.com",
        "ipul@gmail.com",
    )

    val avatar = arrayOf(
        R.drawable.dika,
        R.drawable.andre,
        R.drawable.hendro,
        R.drawable.yeyen,
        R.drawable.kila,
        R.drawable.birol,
        R.drawable.imam,
        R.drawable.indra,
        R.drawable.irvan,
        R.drawable.ipul,
    )

    val getData: ArrayList<Contact>
        get() {
            val list = ArrayList<Contact>()
            for (i in name.indices) {
                list.add(Contact(name[i], number[i], email[i], avatar[i]))
            }
            return list
        }
}