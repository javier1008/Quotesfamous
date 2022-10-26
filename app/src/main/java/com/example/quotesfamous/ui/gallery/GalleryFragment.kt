package com.example.quotesfamous.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.quotesfamous.databinding.FragmentGalleryBinding
import com.example.quotesfamous.domain.model.QuoteModel
import com.example.quotesfamous.presentation.viewmodel.AddQuoteViewModel

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val addQuoteViewModel: AddQuoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        binding.btnAddProperty.setOnClickListener{

            addQuoteViewModel.addquote(
                QuoteModel(id = binding.idQuote.text.toString().toInt(),
                quote = binding.quote.text.toString(),
                author = binding.autorQuote.text.toString())
            )

        }
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}