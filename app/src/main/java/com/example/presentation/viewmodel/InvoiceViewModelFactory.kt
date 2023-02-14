package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.repository.InvoiceRepository
import javax.inject.Inject

class InvoiceViewModelFactory @Inject constructor(private val repo: InvoiceRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass.simpleName) {
            MainViewModel::class.java.simpleName -> {
                @Suppress("UNCHECKED_CAST")
                MainViewModel(repo) as T
            }

            ContactViewModel::class.java.simpleName -> {
                @Suppress("UNCHECKED_CAST")
                ContactViewModel(repo) as T
            }

            else -> {
                throw IllegalArgumentException("ViewModel Not compatible")
            }
        }
    }
}