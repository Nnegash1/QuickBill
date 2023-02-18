package com.example.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.datasource.entites.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDAO {
    @Insert
    suspend fun insertItem(vararg item: Item)

    @Query("SELECT * FROM Item WHERE description = :descriptionName")
    fun getAllItemWithSameDescription(descriptionName: String): Flow<List<Item>>

    @Query("SELECT * FROM Item")
    fun getAllItems(): Flow<List<Item>>

    @Query("SELECT * FROM Item WHERE pk = :id LIMIT 1")
    fun getItemById(id: Int): Flow<Item>
}