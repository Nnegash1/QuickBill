package com.example.data.repository

import com.example.data.datasource.entites.Invoice
import com.example.data.datasource.local.InvoiceDAO
import com.example.domain.repository.InvoiceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class InvoiceRepository @Inject constructor(private val db: InvoiceDAO) : InvoiceRepository {

    override suspend fun getAllInvoice(): Flow<List<Invoice>> = db.getAllInvoice()

    override suspend fun addInvoice(invoice: Invoice) = db.insertAll(invoice)

    override suspend fun deleteInvoice(invoice: Invoice) = db.delete(invoice)

    override suspend fun filterInvoiceByClientName(client: String): Flow<List<Invoice>> {
        val response = db.getAllInvoice()
        return response.map { invoiceList -> invoiceList.filter { it.client.name == client } }
    }

    override suspend fun filterByRefNo(refNo: Long): Flow<List<Invoice>> {
        val response = db.getAllInvoice()
        return response.map { invoiceList ->
            invoiceList.filter {
                it.invoiceDetails.referenceNo == refNo
            }
        }
    }
}