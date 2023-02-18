package com.example.data.datasource.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val pk : Int = 0,
    val description: String = "",
    val brand: String = "",
    val origin: String = "",
    val hsCode: String = "",
    val item: String = "",
    val qty: Int = 0,
    val unitPrice: Double = 0.0,
    val fobPrice: Double = 0.0
) {
    fun onSearch(itemName: String): Boolean {
        val matchCombination = listOf(
            "${description.first()}",
            " $description",
        )
        return matchCombination.any {
            it.contains(itemName, ignoreCase = true)
        }
    }
}
