package com.example.quotesfamous.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesfamous.data.local.QuoteProvider
import com.example.quotesfamous.domain.model.QuoteModel
import com.example.quotesfamous.domain.usecase.GetQuoteRandomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel
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
/*
/// La idea del viewModel es mantener los datos independiente de que sea horizontal o vertical
class QuoteViewModel : ViewModel() {
// QUE ES MutableStateFlow
    private val _quoteModel = MutableStateFlow(QuoteModel("",""))
    val quoteModel: StateFlow<QuoteModel> = _quoteModel //Aqui observa lo que está pasando en la interfaz

    //---  Load data from a suspend fun and mutate state
    // QUE ES viewModelScope
    fun randomQuote() {
        viewModelScope.launch {
            val quote= QuoteProvider.random()
            _quoteModel.value = quote
        }
    }
}*/
