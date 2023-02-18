package com.example.di

import android.app.Application
import androidx.room.Room
import com.example.data.datasource.local.InvoiceDataBase
import com.example.data.repository.BusinessRepositoryImplementation
import com.example.domain.repository.BusinessRepository
import com.example.presentation.viewmodel.InvoiceViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.data.repository.InvoiceRepository as RepoImplementation

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun invoiceViewModelProvider(
        repo: RepoImplementation,
        repoBusinessRepository: BusinessRepository
    ): InvoiceViewModelFactory {
        return InvoiceViewModelFactory(repo, repoBusinessRepository)
    }

    @Provides
    @Singleton
    fun invoiceRepositoryProvider(db: InvoiceDataBase): RepoImplementation {
        return RepoImplementation(db.getDao(), db.getItemDAO())
    }

    @Provides
    @Singleton
    fun businessLogic(db: InvoiceDataBase): BusinessRepository {
        return BusinessRepositoryImplementation(db.getBusinessDAO())
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