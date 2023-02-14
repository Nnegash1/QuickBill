package com.example.domain.repository

import com.example.data.datasource.entites.Invoice
import kotlinx.coroutines.flow.Flow

interface InvoiceRepository {
    suspend fun addInvoice(invoice: Invoice)
    suspend fun getAllInvoice(): Flow<List<Invoice>>
    suspend fun deleteInvoice(invoice: Invoice)
    suspend fun filterInvoiceByClientName(client: String): Flow<List<Invoice>>
    suspend fun filterByRefNo(refNo: Long): Flow<List<Invoice>>
}