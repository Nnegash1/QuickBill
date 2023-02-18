package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.datasource.entites.Item
import com.example.domain.repository.InvoiceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemViewModel @Inject constructor(private val repository: InvoiceRepository) : ViewModel() {

    private val _item = repository.getAllItem()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), listOf())
    private val _searchText = MutableStateFlow("")
    val searchText get() = _searchText.asStateFlow()
    val item: StateFlow<List<Item>>
        get() = combine(_searchText, _item) { text, items ->
            if (text.isBlank()) {
                items
            } else {
                items.filter { it.onSearch(text) }
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(1000), _item.value)


    fun onSearch(name: String) {
        _searchText.value = name
    }

    fun addItemViewModel(item: Item) = viewModelScope.launch {
        withContext(Dispatchers.IO) { repository.addItem(item) }
    }
}