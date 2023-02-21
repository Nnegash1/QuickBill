package com.example.data.datasource.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Client(
    @PrimaryKey(autoGenerate = true)
    val pk: Int = 0,
    val name: String = "",
    val phoneNumber: String,
    val email: String,
    val country: String,
    val postCode: String,
    val state: String,
) {
    fun searchClient(query: String): Boolean {
        val matchCombination = listOf(
            "${name.first()}",
            " $name",
        )
        return matchCombination.any {
            it.contains(query, ignoreCase = true)
        }
    }
}
