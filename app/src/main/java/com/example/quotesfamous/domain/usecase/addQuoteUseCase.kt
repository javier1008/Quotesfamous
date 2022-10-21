package com.example.quotesfamous.domain.usecase

import com.example.quotesfamous.data.local.entities.QuoteEntity
import com.example.quotesfamous.domain.QuoteRepository
import com.example.quotesfamous.domain.model.QuoteModel
import javax.inject.Inject

class addQuoteUseCase @Inject constructor(private val quoteRepository: QuoteRepository){
    suspend fun insert(quote:QuoteModel)= quoteRepository.addQuote(quote)
}