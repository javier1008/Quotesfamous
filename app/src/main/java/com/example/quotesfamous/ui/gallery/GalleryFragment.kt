package com.example.quotesfamous.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.quotesfamous.databinding.FragmentGalleryBinding
import com.example.quotesfamous.presentation.viewmodel.QuoteRandomViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val quotRandomViewModel: QuoteRandomViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //----------------------------
        quotRandomViewModel.randomQuote()
        observer()
        binding.viewContainer.setOnClickListener {
            quotRandomViewModel.randomQuote()
        }

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