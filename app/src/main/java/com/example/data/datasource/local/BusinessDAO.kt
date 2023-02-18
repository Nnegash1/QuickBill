package com.example.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.data.datasource.entites.BusinessSetting

@Dao
interface BusinessDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBusinessDetail(vararg business: BusinessSetting)
}
