package com.example.quotesfamous.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesfamous.domain.model.QuoteModel
import com.example.quotesfamous.domain.usecase.GetQuoteRandomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteRandomViewModel
@Inject constructor(private val getQuoteRandomUseCase: GetQuoteRandomUseCase
): ViewModel() {

    private val quoteModelRandomMutableStateFlow = MutableStateFlow(QuoteModel(0,"",""))
    val quoteModel: StateFlow<QuoteModel> = quoteModelRandomMutableStateFlow


    fun randomQuote() {
        viewModelScope.launch {
            quoteModelRandomMutableStateFlow.value = getQuoteRandomUseCase.getQuoteRandom().first()
            //_quoteModel.value = GetQuoteUseCase(quoteDAO).getQuote(1).first()
        }
    }
}