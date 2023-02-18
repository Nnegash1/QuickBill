package com.example.data.datasource.entites


data class Client(
    val name: String = "",
    val phoneNumber: String,
    val email: String,
    val country: String,
    val street: String,
    val apt: String,
    val postCode: String,
    val city: String,
    val province: String,
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
