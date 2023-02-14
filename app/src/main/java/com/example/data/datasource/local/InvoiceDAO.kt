package com.example.data.datasource.local

import androidx.room.*
import com.example.data.datasource.entites.Invoice
import kotlinx.coroutines.flow.Flow


@Dao
interface InvoiceDAO {
    @Insert
    suspend fun insertAll(vararg users: Invoice)

    @Delete
    suspend fun delete(invoice: Invoice)

    @Query("Select * From Invoice")
    fun getAllInvoice(): Flow<List<Invoice>>

}
