package com.example.shepherdproduct.layer_presenter.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.shepherdproduct.databinding.ActivityMainBinding
import com.example.superwallet.util.extension.afterTextChanged
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        eventAttach()
        eventObserve()
    }
    private fun eventAttach(){
        binding.inputEditText.afterTextChanged {
            viewModel.inputTextAfterTextChanged(it)
        }
        binding.searchButton.setOnClickListener {
            viewModel.search()
        }
    }
    private fun eventObserve(){

    }
}