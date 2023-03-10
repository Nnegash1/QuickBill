package com.example.domain.repository

import com.example.data.datasource.entites.Invoice
import com.example.data.datasource.entites.Item
import kotlinx.coroutines.flow.Flow

interface InvoiceRepository {
    suspend fun addInvoice(invoice: Invoice)
    suspend fun deleteInvoice(invoice: Invoice)
    fun filterInvoiceByClientName(client: String): Flow<List<Invoice>>
    fun filterByRefNo(refNo: Long): Flow<List<Invoice>>
    fun sortByDate(): Flow<List<Invoice>>
    fun sortByPrice(): Flow<List<Invoice>>
    fun addItem(item: Item)
    fun getAllItem(): Flow<List<Item>>
}