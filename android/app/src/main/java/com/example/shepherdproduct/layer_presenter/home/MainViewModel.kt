package com.example.shepherdproduct.layer_presenter.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shepherdproduct.layer_domain.data.SearchType
import com.example.shepherdproduct.layer_domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val searchUseCase: SearchUseCase): ViewModel() {

    companion object{
        val TAG = "MainViewModel"
    }
//    private val _inputText = MutableLiveData<String>()
//    val inputText : LiveData<String> = _inputText
//

    private var inputText:String = ""

    fun inputTextAfterTextChanged(input:String){
        inputText = input
    }

    fun search(){
        Log.d(TAG, "search click")
        searchUseCase.execute(inputText, SearchType.Product)
    }
}