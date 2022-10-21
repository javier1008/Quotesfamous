package com.example.quotesfamous.data.local

import com.example.quotesfamous.domain.QuoteRepository
import com.example.quotesfamous.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteRepositoryImpl @Inject constructor (private val localDataSource: QuoteLocalDataSource):
    QuoteRepository {

    override suspend fun getQuoteRandom(): Flow<QuoteModel> {
        return  localDataSource.getQuoteRandom()
    }

    override suspend fun getQuote(quoteId: Int): Flow<QuoteModel> {
        return localDataSource.getQuote(quoteId)
    }

    override suspend fun addQuote(quote: QuoteModel){
        return localDataSource.insert(quote)
    }

}
