package com.example.di

import android.app.Application
import androidx.room.Room
import com.example.data.datasource.local.InvoiceDataBase
import com.example.data.repository.InvoiceRepository as RepoImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

//    @Provides
//    @Singleton
//    fun invoiceViewModelProvider(repo: RepoImplementation): InvoiceViewModelFactory {
//        return InvoiceViewModelFactory(repo)
//    }

    @Provides
    @Singleton
    fun invoiceRepositoryProvider(db: InvoiceDataBase): RepoImplementation {
        return RepoImplementation(db.getDao())
    }

    @Provides
    @Singleton
    fun provideDataBase(app: Application) = Room.databaseBuilder(
        app,
        InvoiceDataBase::class.java,
        InvoiceDataBase.INVOICE_NAME
    ).build()

    @Provides
    fun provideDao(db: InvoiceDataBase) = db.getDao()
}