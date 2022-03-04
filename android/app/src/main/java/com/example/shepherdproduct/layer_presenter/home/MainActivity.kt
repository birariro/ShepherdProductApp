package com.example.shepherdproduct.layer_presenter.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.shepherdproduct.databinding.ActivityMainBinding
import com.example.shepherdproduct.layer_domain.data.SearchType
import com.example.shepherdproduct.layer_presenter.result.ErrorPopupActivity
import com.example.shepherdproduct.layer_presenter.result.GoodPopupActivity
import com.example.shepherdproduct.layer_presenter.result.listview.BadDataActivity
import com.example.superwallet.util.extension.afterTextChanged
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object{
        val TAG = "MainActivity"
    }
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
            binding.loading.visibility = View.VISIBLE
            viewModel.search()
        }
        binding.searchRadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            if(i == binding.companyRadioButton.id){
                viewModel.searchType(SearchType.Company)
            }else{
                viewModel.searchType(SearchType.Product)
            }
        }

    }
    private fun eventObserve(){
        viewModel.searchDataList.observe(this){
            binding.loading.visibility = View.INVISIBLE

            if(! it.success){
                val intent = Intent(this, ErrorPopupActivity::class.java)
                startActivity(intent)
                return@observe
            }

            if(it.data.isEmpty()){
                val intent = Intent(this, GoodPopupActivity::class.java)
                startActivity(intent)

            }else{
                val intent = Intent(this, BadDataActivity::class.java)
                intent.putExtra("searchData", it)
                startActivity(intent)
            }


        }
    }
}