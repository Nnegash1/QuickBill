package com.example.data.datasource.entites

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BusinessSetting(
    @PrimaryKey(autoGenerate = true)
    val pk: Int = 0,
    val businessName: String,
    val country: String,
    val street: String,
    val postCode: String,
    val city: String,
    val state: String,
    val taxRegNo: String,
    val contactPerson: String,
    val phoneNumber: String,
    val email: String,
    val image: Bitmap? = null
)