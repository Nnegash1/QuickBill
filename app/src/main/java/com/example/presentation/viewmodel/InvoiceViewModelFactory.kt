package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.repository.BusinessRepository
import com.example.domain.repository.ClientRepository
import com.example.domain.repository.InvoiceRepository
import javax.inject.Inject

class InvoiceViewModelFactory @Inject constructor(
    private val repo: InvoiceRepository,
    private val businessRepo: BusinessRepository,
    private val clientRepository: ClientRepository
) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass.simpleName) {
            MainViewModel::class.java.simpleName -> {
                @Suppress("UNCHECKED_CAST")
                MainViewModel(repo, businessRepo) as T
            }
            ContactViewModel::class.java.simpleName -> {
                @Suppress("UNCHECKED_CAST")
                ContactViewModel(clientRepository) as T
            }
            ItemViewModel::class.java.simpleName -> {
                @Suppress("UNCHECKED_CAST")
                ItemViewModel(repo) as T
            }
            else -> {
                throw IllegalArgumentException("ViewModel Not compatible")
            }
        }
    }
}