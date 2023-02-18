package com.example.data.datasource.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
data class Invoice(
    @PrimaryKey(autoGenerate = true)
    val pk: Int = 0,
    @ColumnInfo(name = "Client")
    val client: Client,
    @ColumnInfo(name = "Item")
    val item: List<Item>,
    @ColumnInfo(name = "InvoiceNumber")
    val invoiceNumber: String = "",
    @ColumnInfo(name = "DueDate")
    val dueDate: Date = Date(),
    @ColumnInfo(name = "Discount")
    val discount: Double = 0.0,
    @ColumnInfo(name = "Percent Discount")
    val percentDiscount: Double = 0.0,
    @ColumnInfo(name = "ReferenceNo")
    val referenceNo: Long = Random().nextLong(),
    @ColumnInfo(name = "TotalPrice")
    val totalPrice: Double,
    @ColumnInfo(name = "Date")
    val issueDate: Date = Date()
)