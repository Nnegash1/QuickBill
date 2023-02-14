package com.example.data.datasource.local

import com.example.data.datasource.entites.Client
import com.example.data.datasource.entites.Invoice
import com.example.data.datasource.entites.InvoiceDetails
import com.example.data.datasource.entites.Item
import java.util.Date
import java.util.Random


val mock_data = listOf(
    Invoice(
        item = listOf(
            Item(
                "1200R20 668 22PR",
                "TRIANGLE",
                "CHINA",
                "40111000",
                "TIRE",
                12,
                12.0,
                12.0,
            )
        ),
        client = Client(
            "Kifle",
            phoneNumber = "000-000-0000",
            email = "nahom@gmail.com",
            country = "Ethiopia",
            street = "Addis Ababa",
            apt = "123",
            postCode = "20866",
            city = null,
            province = null
        ),
        invoiceDetails = InvoiceDetails(
            invoiceNumber = Random().nextLong().toString(),
            issueDate = Date().toString()
        )
    ),

    Invoice(
        item = listOf(
            Item(
                "1200R20 668 22PR",
                "TRIANGLE",
                "CHINA",
                "40111000",
                "TIRE",
                12,
                12.0,
                12.0,
            )
        ),
        client = Client(
            "Eyob",
            phoneNumber = "000-000-0000",
            email = "nahom@gmail.com",
            country = "Ethiopia",
            street = "Addis Ababa",
            apt = "123",
            postCode = "20866",
            city = null,
            province = null
        ),
        invoiceDetails = InvoiceDetails(
            invoiceNumber = Random().nextLong().toString(),
            issueDate = Date().toString()
        )
    ),

    Invoice(

        item = listOf(
            Item(
                "1200R20 668 22PR",
                "TRIANGLE",
                "CHINA",
                "40111000",
                "TIRE",
                12,
                12.0,
                12.0,
            )
        ),
        client = Client(
            "Nahom",
            phoneNumber = "000-000-0000",
            email = "nahom@gmail.com",
            country = "Ethiopia",
            street = "Addis Ababa",
            apt = "123",
            postCode = "20866",
            city = null,
            province = null
        ),
        invoiceDetails = InvoiceDetails(
            invoiceNumber = Random().nextLong().toString(),
            issueDate = Date().toString()

        )
    )
)

val client_mock = listOf(
    Client(
        "Kifle",
        phoneNumber = "000-000-0000",
        email = "nahom@gmail.com",
        country = "Ethiopia",
        street = "Addis Ababa",
        apt = "123",
        postCode = "20866",
        city = null,
        province = null
    ),
    Client(
        "Nahom",
        phoneNumber = "000-000-0000",
        email = "nahom@gmail.com",
        country = "Ethiopia",
        street = "Addis Ababa",
        apt = "123",
        postCode = "20866",
        city = null,
        province = null
    ),
    Client(
        "Negash",
        phoneNumber = "000-000-0000",
        email = "nahom@gmail.com",
        country = "Ethiopia",
        street = "Addis Ababa",
        apt = "123",
        postCode = "20866",
        city = null,
        province = null
    ),
    Client(
        "Baba",
        phoneNumber = "000-000-0000",
        email = "nahom@gmail.com",
        country = "Ethiopia",
        street = "Addis Ababa",
        apt = "123",
        postCode = "20866",
        city = null,
        province = null
    ),
    Client(
        "Kidus",
        phoneNumber = "000-000-0000",
        email = "nahom@gmail.com",
        country = "Ethiopia",
        street = "Addis Ababa",
        apt = "123",
        postCode = "20866",
        city = null,
        province = null
    ),
    Client(
        "Shewa",
        phoneNumber = "000-000-0000",
        email = "nahom@gmail.com",
        country = "Ethiopia",
        street = "Addis Ababa",
        apt = "123",
        postCode = "20866",
        city = null,
        province = null
    ),
    Client(
        "Honey",
        phoneNumber = "000-000-0000",
        email = "nahom@gmail.com",
        country = "Ethiopia",
        street = "Addis Ababa",
        apt = "123",
        postCode = "20866",
        city = null,
        province = null
    )
)