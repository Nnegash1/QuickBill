package com.example.domain.repository

import com.example.data.datasource.entites.Client
import kotlinx.coroutines.flow.Flow

interface ClientRepository {
    suspend fun addClient(client: Client)
    fun getAllClient(): Flow<List<Client>>
}