package com.example.quotesfamous.domain.usecase

import com.example.quotesfamous.domain.QuoteRepository
import com.example.quotesfamous.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    suspend fun getQuote(quoteId: Int): Flow<QuoteModel> = quoteRepository.getQuote(quoteId)

}
