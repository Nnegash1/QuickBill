package com.example.data.datasource.entites

data class Item(
    val description: String = "",
    val brand: String = "",
    val origin: String = "",
    val hs_code: String ="",
    val item: String ="",
    val qty: Int = 0,
    val unit_price: Double=0.0,
    val fob_price: Double = 0.0
)
