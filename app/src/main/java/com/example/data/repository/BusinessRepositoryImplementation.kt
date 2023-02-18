package com.example.data.repository

import android.content.Context
import androidx.core.graphics.drawable.toBitmap
import com.example.data.datasource.entites.BusinessSetting
import com.example.data.datasource.local.BusinessDAO
import com.example.domain.repository.BusinessRepository
import com.example.quickbill.R

class BusinessRepositoryImplementation(private val businessDAO: BusinessDAO) : BusinessRepository {
    override suspend fun addBusinessDetails(business: BusinessSetting, context: Context) {
        val x = BusinessSetting(
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
            image = context.resources.getDrawable(R.drawable.ic_launcher_foreground).toBitmap()

        )
        businessDAO.addBusinessDetail(x)
    }
}