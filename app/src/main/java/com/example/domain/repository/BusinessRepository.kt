package com.example.domain.repository

import android.content.Context
import com.example.data.datasource.entites.BusinessSetting

interface BusinessRepository {
    suspend fun addBusinessDetails(business: BusinessSetting, context: Context)
}