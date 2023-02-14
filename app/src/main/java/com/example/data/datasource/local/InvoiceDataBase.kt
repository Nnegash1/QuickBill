package com.example.data.datasource.local


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.datasource.entites.Invoice
import com.example.data.datasource.entites.InvoiceTypeConverter

@Database(
    entities = [Invoice::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(InvoiceTypeConverter::class)
abstract class InvoiceDataBase : RoomDatabase() {
    abstract fun getDao(): InvoiceDAO
    companion object {
        const val INVOICE_NAME = "InvoiceTable.db"
    }
}
