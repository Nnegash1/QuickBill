package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.datasource.entites.Client
import com.example.domain.repository.ClientRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ContactViewModel @Inject constructor(val repository: ClientRepository) : ViewModel() {
    private val _client = repository.getAllClient()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(1000), listOf())
    private val _searchText = MutableStateFlow("")
    val searchText get() = _searchText.asStateFlow()
    val client: StateFlow<List<Client>>
        get() = combine(_searchText, _client) { text, client ->
            if (text.isBlank()) {
                client
            } else {
                client.filter { it.searchClient(text) }
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(1000), _client.value)

    fun onSearch(name: String) {
        _searchText.value = name
    }

    fun addClient(client: Client) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.addClient(client = client)
        }
    }
}
