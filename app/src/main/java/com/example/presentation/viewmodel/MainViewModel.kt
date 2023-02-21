package com.example.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.datasource.entites.Invoice
import com.example.data.datasource.local.businessDetail
import com.example.domain.repository.BusinessRepository
import com.example.domain.repository.InvoiceRepository
import com.example.other.SortType
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: InvoiceRepository,
    private val businessRepo: BusinessRepository
) : ViewModel() {
    private val _invoicesSortByDate get() = repository.sortByDate()
    private val _invoicesSortByPrice get() = repository.sortByPrice()
    private val _invoice = MutableStateFlow(listOf<Invoice>())
    private val _searchText = MutableStateFlow("")
    private var sortType = SortType.DATE
    val searchText get() = _searchText.asStateFlow()

    val invoice: StateFlow<List<Invoice>>
        get() = combine(_searchText, _invoice) { text, invoices ->
            if (text.isBlank()) {
                invoices
            } else {
                invoices.filter {
                    it.client.searchClient(text)
                }
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(1000), _invoice.value)

    init {
        combine(_invoicesSortByDate, _invoicesSortByPrice) { byDate, byPrice ->
            when (sortType) {
                SortType.DATE -> byDate.let { _invoice.value = it }
                SortType.PRICE -> byPrice.let { _invoice.value = it }
            }
        }.launchIn(viewModelScope)
    }

    fun sortInvoice(sortType: SortType) {
        viewModelScope.launch {
            when (sortType) {
                SortType.DATE -> {
                    _invoicesSortByDate.first().let { _invoice.value = it }
                }

                SortType.PRICE -> {
                    _invoicesSortByPrice.first().let { _invoice.value = it }
                }
            }
        }
        this.sortType = sortType
    }

    fun onSearch(name: String) {
        _searchText.value = name
    }

    fun addInvoice(invoice: Invoice, context: Context) = viewModelScope.launch {
        //businessRepo.addBusinessDetails(businessDetail, context)
        repository.addInvoice(invoice)
    }
}