package com.example.quotesfamous.presentation.view
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.quotesfamous.databinding.ActivityQuoteRandomBinding
import com.example.quotesfamous.presentation.viewmodel.QuoteRandomViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteRandomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuoteRandomBinding
    private val quotRandomViewModel: QuoteRandomViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuoteRandomBinding.inflate(layoutInflater)
        setContentView(binding.root) ///Esta linea es responsable de mostrar las vistas al inicio

        //----------------------------
        quotRandomViewModel.randomQuote()
        observer()
        binding.viewContainer.setOnClickListener {
            quotRandomViewModel.randomQuote()
        }

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

/*class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //----------------------------
        quoteViewModel.randomQuote()
        observer()
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }

    }
    private fun observer(){
        lifecycleScope.launch {
            quoteViewModel.quoteModel.collect {
                binding.tvQuote.text = it.quote
                binding.tvAuthor.text= it.author
            }
        }
    }*/

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }*/
    /*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }*/
