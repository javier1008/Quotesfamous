package com.example.quotesfamous.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quotesfamous.R
import com.example.quotesfamous.databinding.ActivityAddQuoteBinding
import com.example.quotesfamous.domain.model.QuoteModel
import com.example.quotesfamous.domain.usecase.addQuoteUseCase
import com.example.quotesfamous.presentation.viewmodel.AddQuoteViewModel

class AddQuoteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddQuoteBinding
    private lateinit var addQuoteViewModel: AddQuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_add_quote)
    binding.btnAddProperty.setOnClickListener{

        addQuoteViewModel.addquote(QuoteModel(id = binding.idQuote.text.toString().toInt(),
        quote = binding.quote.text.toString(),
        author = binding.autorQuote.text.toString()))

    }
    }
}