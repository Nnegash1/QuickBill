package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.datasource.entites.Invoice
import com.example.domain.repository.InvoiceRepository
import com.example.other.SortType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

class MainViewModel(private val repository: InvoiceRepository) : ViewModel() {
    private val _invoicesSortByDate get() = repository.sortByDate()
    private val _invoicesSortByName get() = repository.sortByName()
    private val _invoice = MutableStateFlow(listOf<Invoice>())
    val invoice get() = _invoice.asStateFlow()
    private var sortType = SortType.DATE

    init {
        combine(_invoicesSortByDate, _invoicesSortByName) { byDate, byName ->
            when (sortType) {
                SortType.DATE -> byDate.let { _invoice.value = it }
                SortType.NAME -> byName.let { _invoice.value = it }
            }
        }.launchIn(viewModelScope)
    }

    fun sortInvoice(sortType: SortType) {
        viewModelScope.launch {
            when (sortType) {
                SortType.DATE -> { _invoicesSortByDate.firstOrNull()?.let { _invoice.value = it } }
                SortType.NAME -> { _invoicesSortByName.firstOrNull()?.let { _invoice.value = it } }
            }
        }
        this.sortType = sortType
    }
}