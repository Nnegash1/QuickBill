package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.datasource.entites.Client
import com.example.domain.repository.InvoiceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class ContactViewModel @Inject constructor(val repository: InvoiceRepository) : ViewModel() {
    private val _client = repository.getAllClientContact()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), listOf())
    private val _searchText = MutableStateFlow("")
    val searchText get() = _searchText.asStateFlow()
    val client: StateFlow<List<Client>>
        get() = combine(_searchText, _client) { text, client ->
            if (text.isBlank()) {
                client
            } else {
                client.filter {
                    it.searchClient(text)
                }
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(1000), _client.value)

    fun onSearch(name: String) {
        _searchText.value = name
    }
}
