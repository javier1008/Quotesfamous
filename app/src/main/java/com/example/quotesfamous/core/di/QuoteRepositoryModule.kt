package com.example.quotesfamous.core.di

import com.example.quotesfamous.data.local.QuoteLocalDataSource
import com.example.quotesfamous.data.local.QuoteLocalDataSourceImpl
import com.example.quotesfamous.data.remote.QuoteRepositoryImpl
import com.example.quotesfamous.domain.QuoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class QuoteRepositoryModule {

    @Binds
    abstract fun bindQuoteRepository(quoteRepositoryImpl: QuoteRepositoryImpl):
            QuoteRepository

    @Binds
    abstract fun bindQuoteLocalDataSource(quoteLocalDataSourceImpl: QuoteLocalDataSourceImpl):
            QuoteLocalDataSource

}