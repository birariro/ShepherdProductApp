package com.example.shepherdproduct.layer_presenter.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shepherdproduct.layer_domain.data.SearchData
import com.example.shepherdproduct.layer_domain.data.SearchType
import com.example.shepherdproduct.layer_domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val searchUseCase: SearchUseCase): ViewModel() {

    companion object{
        val TAG = "MainViewModel"
    }
    private val _searchDataList = MutableLiveData<List<SearchData>>()
    val searchDataList : LiveData<List<SearchData>> = _searchDataList
//

    private var inputText:String = ""

    fun inputTextAfterTextChanged(input:String){
        inputText = input
    }

    fun search(){
        Log.d(TAG, "search click")
        viewModelScope.launch {
            val execute = searchUseCase.execute(inputText, SearchType.Product)
            Log.d(TAG, "execute : $execute")
            _searchDataList.value = execute
        }

    }
}