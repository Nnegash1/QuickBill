package com.example.data.repository

import com.example.data.datasource.entites.Invoice
import com.example.data.datasource.entites.Item
import com.example.data.datasource.local.InvoiceDAO
import com.example.data.datasource.local.ItemDAO
import com.example.domain.repository.InvoiceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class InvoiceRepository @Inject constructor(
    private val db: InvoiceDAO,
    private val itemDb: ItemDAO
) : InvoiceRepository {

    override suspend fun addInvoice(invoice: Invoice) = db.insertAll(invoice)

    override suspend fun deleteInvoice(invoice: Invoice) = db.delete(invoice)

    override fun filterInvoiceByClientName(client: String): Flow<List<Invoice>> {
        val response = db.getAllInvoice()
        return response.map { invoiceList -> invoiceList.filter { it.client.name == client } }
    }

    override fun filterByRefNo(refNo: Long): Flow<List<Invoice>> {
        val response = db.getAllInvoice()
        return response.map { invoiceList ->
            invoiceList.filter {
                it.referenceNo == refNo
            }
        }
    }

    override fun sortByDate(): Flow<List<Invoice>> = db.sortByDate()

    override fun sortByPrice(): Flow<List<Invoice>> = db.sortByPrice()

    override fun addItem(item: Item) {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            val response = itemDb.getAllItemWithSameDescription(item.description)
            if (response.first().isEmpty()) {
                itemDb.insertItem(item)
            }
        }
    }

    override fun getAllItem(): Flow<List<Item>> = itemDb.getAllItems()

}