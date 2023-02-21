package com.example.data.datasource.local


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.datasource.entites.*

@Database(
    entities = [Invoice::class, Item::class, BusinessSetting::class, Client::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(InvoiceTypeConverter::class)
abstract class InvoiceDataBase : RoomDatabase() {
    abstract fun getDao(): InvoiceDAO
    abstract fun getItemDAO(): ItemDAO

    abstract fun getBusinessDAO(): BusinessDAO

    abstract fun getClientDAO(): ClientDAO

    companion object {
        const val INVOICE_NAME = "InvoiceTable.db"
    }
}
