package com.example.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.datasource.entites.Client
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addClient(client: Client)

    @Query("SELECT * FROM Client")
    fun getAllClient(): Flow<List<Client>>
}