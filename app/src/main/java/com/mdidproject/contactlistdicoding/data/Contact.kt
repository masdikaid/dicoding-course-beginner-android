package com.mdidproject.contactlistdicoding.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    var name: String,
    var number: String,
    var email: String,
    var avatar: Int = 0
): Parcelable
