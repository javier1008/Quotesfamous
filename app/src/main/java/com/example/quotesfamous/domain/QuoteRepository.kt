package com.example.quotesfamous.domain

import com.example.quotesfamous.data.local.entities.QuoteEntity
import com.example.quotesfamous.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    // suspend fun getQuotes(): Flow<QuoteResponse?>
    suspend fun getQuoteRandom(): Flow<QuoteModel>
    suspend fun getQuote(quoteId:Int): Flow<QuoteModel>
    //suspend fun editQuote(quoteModel: QuoteModel, token:String): Flow<QuoteResponse?>
    //suspend fun addQuote(quoteModel: QuoteModel, token:String): Flow<QuoteModel?>
    suspend fun addQuote(quoteModel: QuoteModel)
}
