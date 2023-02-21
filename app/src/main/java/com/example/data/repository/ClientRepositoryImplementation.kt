package com.example.data.repository

import com.example.data.datasource.entites.Client
import com.example.data.datasource.local.ClientDAO
import com.example.domain.repository.ClientRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ClientRepositoryImplementation @Inject constructor(private val clientDAO: ClientDAO) :
    ClientRepository {
    override suspend fun addClient(client: Client) {
        clientDAO.addClient(client)
    }

    override fun getAllClient(): Flow<List<Client>> = clientDAO.getAllClient()

}