package com.example.data.repository

import com.example.data.datasource.entites.Invoice
import com.example.data.datasource.local.InvoiceDAO
import com.example.data.datasource.local.mock_data
import com.example.domain.repository.InvoiceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class InvoiceRepository @Inject constructor(private val db: InvoiceDAO) : InvoiceRepository {

    override suspend fun addInvoice(invoice: Invoice) = db.insertAll(invoice)

    override suspend fun deleteInvoice(invoice: Invoice) = db.delete(invoice)

    override fun filterInvoiceByClientName(client: String): Flow<List<Invoice>> {
        val response = flowOf(mock_data)
        return response.map { invoiceList -> invoiceList.filter { it.client.name == client } }
    }

    override fun filterByRefNo(refNo: Long): Flow<List<Invoice>> {
        val response = flowOf(mock_data)
        return response.map { invoiceList ->
            invoiceList.filter {
                it.invoiceDetails.referenceNo == refNo
            }
        }
    }

    override fun sortByDate(): Flow<List<Invoice>> {
        val response = flowOf(mock_data)
        return response.map {
            it.sortedByDescending { invoice -> invoice.invoiceDetails.dueDate }
        }
    }

    override fun sortByName(): Flow<List<Invoice>> {
        val response = flowOf(mock_data)
        return response.map {
            it.sortedByDescending { invoice -> invoice.client.name }
        }
    }
}