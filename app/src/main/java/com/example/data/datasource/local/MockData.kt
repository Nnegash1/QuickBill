package com.example.data.datasource.local

import com.example.data.datasource.entites.BusinessSetting
import com.example.data.datasource.entites.Client
import com.example.data.datasource.entites.Invoice
import com.example.data.datasource.entites.Item
import java.util.*


val mock_data =
    Invoice(
        invoiceNumber = Random().nextLong().toString(),
        issueDate = Date(),
        item = listOf(
            Item(
                description = "1200R20 668 22PR",
                brand = "TRIANGLE",
                origin = "CHINA",
                hsCode = "40111000",
                item = "TIRE",
                qty = 12,
                unitPrice = 12.0,
                fobPrice = 12.0,
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
            city = "",
            province = ""
        ),
        totalPrice = 12.0
    )

//
//    Invoice(
//        item = listOf(
//            Item(
//                description = "1200R20 668 22PR",
//                brand = "TRIANGLE",
//                origin = "CHINA",
//                hsCode = "40111000",
//                item ="TIRE",
//                qty = 12,
//                unitPrice = 12.0,
//                fobPrice = 12.0,
//            ),
//            Item(
//                description = "1200R20 668 22PR",
//                brand = "TRIANGLE",
//                origin = "CHINA",
//                hsCode = "40111000",
//                item ="TIRE",
//                qty = 12,
//                unitPrice = 12.0,
//                fobPrice = 12.0,
//            ),
//            Item(
//                description = "1200R20 668 22PR",
//                brand = "TRIANGLE",
//                origin = "CHINA",
//                hsCode = "40111000",
//                item ="TIRE",
//                qty = 12,
//                unitPrice = 12.0,
//                fobPrice = 12.0,
//            )
//        ),
//        client = Client(
//            "Eyob",
//            phoneNumber = "000-000-0000",
//            email = "nahom@gmail.com",
//            country = "Ethiopia",
//            street = "Addis Ababa",
//            apt = "123",
//            postCode = "20866",
//            city = "",
//            province = ""
//        ),
//        invoiceDetails = InvoiceDetails(
//            invoiceNumber = Random().nextLong().toString(),
//            issueDate = Date().toString()
//        ),
//        totalPrice = 12.0
//    ),
//
//    Invoice(
//
//        item = listOf(
//            Item(
//                description = "1200R20 668 22PR",
//                brand = "TRIANGLE",
//                origin = "CHINA",
//                hsCode = "40111000",
//                item ="TIRE",
//                qty = 12,
//                unitPrice = 12.0,
//                fobPrice = 12.0,
//            )
//        ),
//        client = Client(
//            "Nahom",
//            phoneNumber = "000-000-0000",
//            email = "nahom@gmail.com",
//            country = "Ethiopia",
//            street = "Addis Ababa",
//            apt = "123",
//            postCode = "20866",
//            city = "",
//            province = ""
//        ),
//        invoiceDetails = InvoiceDetails(
//            invoiceNumber = Random().nextLong().toString(),
//            issueDate = Date().toString()
//
//        ),
//        totalPrice = 12.0
//    )
//)

val client_mock = listOf(
    Client(
        "Kifle",
        phoneNumber = "000-000-0000",
        email = "nahom@gmail.com",
        country = "Ethiopia",
        street = "Addis Ababa",
        apt = "123",
        postCode = "20866",
        city = "",
        province = ""
    ),
    Client(
        "Nahom",
        phoneNumber = "000-000-0000",
        email = "nahom@gmail.com",
        country = "Ethiopia",
        street = "Addis Ababa",
        apt = "123",
        postCode = "20866",
        city = "",
        province = ""
    ),
    Client(
        "Negash",
        phoneNumber = "000-000-0000",
        email = "nahom@gmail.com",
        country = "Ethiopia",
        street = "Addis Ababa",
        apt = "123",
        postCode = "20866",
        city = "",
        province = ""
    ),
    Client(
        "Baba",
        phoneNumber = "000-000-0000",
        email = "nahom@gmail.com",
        country = "Ethiopia",
        street = "Addis Ababa",
        apt = "123",
        postCode = "20866",
        city = "",
        province = ""
    ),
    Client(
        "Kidus",
        phoneNumber = "000-000-0000",
        email = "nahom@gmail.com",
        country = "Ethiopia",
        street = "Addis Ababa",
        apt = "123",
        postCode = "20866",
        city = "",
        province = ""
    ),
    Client(
        "Shewa",
        phoneNumber = "000-000-0000",
        email = "nahom@gmail.com",
        country = "Ethiopia",
        street = "Addis Ababa",
        apt = "123",
        postCode = "20866",
        city = "",
        province = ""
    ),
    Client(
        "Honey",
        phoneNumber = "000-000-0000",
        email = "nahom@gmail.com",
        country = "Ethiopia",
        street = "Addis Ababa",
        apt = "123",
        postCode = "20866",
        city = "",
        province = ""
    ),
)

val businessDetail = BusinessSetting(
    businessName = "Tire",
    country = "Ethiopia",
    street = "Kirkos",
    postCode = "10992",
    city = "AddisAbaba",
    state = "MD",
    taxRegNo = "102121",
    contactPerson = "Kifle",
    phoneNumber = "210-221-1100",
    email = "nn@gmail.com",
    image = null
)