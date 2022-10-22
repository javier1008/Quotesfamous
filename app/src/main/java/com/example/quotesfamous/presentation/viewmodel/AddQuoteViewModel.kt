package com.example.quotesfamous.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesfamous.domain.model.QuoteModel
import com.example.quotesfamous.domain.usecase.addQuoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddQuoteViewModel
@Inject constructor(private val addQuoteViewModelt: addQuoteUseCase
): ViewModel() {
    //private val addquote = QuoteModel(0,"","")
    private val quoteModelRandomMutableStateFlow = MutableStateFlow(QuoteModel(0,"",""))
     fun addquote(quoteModel: QuoteModel){
        //addquote= addQuoteViewModelt.insert(QuoteModel)
        //quoteModelRandomMutableStateFlow.value= addQuoteViewModelt.insert(quote = quoteModel)
         viewModelScope.launch {
         val contenido=addQuoteViewModelt.insert(quote = quoteModel)
         }
    }

}