package com.example.shepherdproduct.layer_presenter.home

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.shepherdproduct.databinding.ActivityMainBinding
import com.example.shepherdproduct.layer_presenter.result.BadPopupActivity
import com.example.shepherdproduct.layer_presenter.result.ErrorPopupActivity
import com.example.shepherdproduct.layer_presenter.result.GoodPopupActivity
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
    private fun initUI(){
        binding.loading.visibility = View.INVISIBLE
    }

    private fun eventAttach(){

        binding.inputEditText.afterTextChanged {
            viewModel.inputTextAfterTextChanged(it)
        }
        binding.searchButton.setOnClickListener {

            binding.loading.visibility = View.VISIBLE
            viewModel.search()
        }

        binding.inputEditText.setText("쇼핑")
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
                Log.d(TAG,"searchDataList count 0")

            }else{
                Log.d(TAG,"searchDataList count ${it.data.count()}")
            }
            val intent = Intent(this, GoodPopupActivity::class.java)
            startActivity(intent)
        }
    }
}