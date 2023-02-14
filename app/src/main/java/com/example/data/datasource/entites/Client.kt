package com.example.data.datasource.entites


data class Client(
    val name: String = "",
    val phoneNumber: String? = null,
    val email: String? = null,
    val country: String? = null,
    val street: String? = null,
    val apt: String? = null,
    val postCode: String? = null,
    val city: String? = null,
    val province: String? = null,
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
