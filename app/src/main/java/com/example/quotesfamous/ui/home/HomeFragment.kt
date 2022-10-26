package com.example.quotesfamous.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.quotesfamous.databinding.ActivityQuoteRandomBinding
import com.example.quotesfamous.databinding.FragmentHomeBinding
import com.example.quotesfamous.presentation.viewmodel.QuoteRandomViewModel
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    //private lateinit var bindings: FragmentHomeBinding


    private val quotRandomViewModel: QuoteRandomViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        //bindings = FragmentHomeBinding.inflate(layoutInflater)
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        /*quotRandomViewModel.randomQuote()
        observer()
        binding.viewContainer.setOnClickListener {
            quotRandomViewModel.randomQuote()
        }*/
        binding.tvQuote.setText("AYER LA VI POR LA CALLE")
        val root: View = binding.root

        return root



    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
   private fun observer(){
        lifecycleScope.launch {
            quotRandomViewModel.quoteModel.collect {
                binding.tvQuote.text = it.quote
                binding.tvAuthor.text= it.author
            }
        }
    }
}