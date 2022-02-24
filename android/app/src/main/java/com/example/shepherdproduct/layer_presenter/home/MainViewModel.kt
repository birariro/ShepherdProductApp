package com.example.shepherdproduct.layer_presenter.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shepherdproduct.layer_domain.data.SearchData
import com.example.shepherdproduct.layer_domain.data.SearchDataBody
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
    private val _searchDataList = MutableLiveData<SearchData>()
    val searchDataList : LiveData<SearchData> = _searchDataList

    private var inputText:String = ""
    private var searchType = SearchType.Product

    fun inputTextAfterTextChanged(input:String){
        inputText = input
    }

    fun search(){
        Log.d(TAG, "search click")
        viewModelScope.launch {
            val execute = searchUseCase.execute(inputText, searchType)
            //val execute = dummySearchData()
            Log.d(TAG, "execute : $execute")
            _searchDataList.value = execute

        }

    }
    fun searchType(searchType: SearchType){
        this.searchType = searchType
    }
    private fun dummySearchData() :SearchData{
        val searchDataBodyList = mutableListOf<SearchDataBody>()
//        searchDataBodyList.add(SearchDataBody(company = "A회사",product = "아주 좋은 화장품"))
//        searchDataBodyList.add(SearchDataBody(company = "B라는 회사",product = "여드름 바로 없어지는 화장품"))
//        searchDataBodyList.add(SearchDataBody(company = "컴퍼니",product = "키가 크는 화장품"))
//        searchDataBodyList.add(SearchDataBody(company = "저기 회사",product = "이뻐지는 크림"))
//        searchDataBodyList.add(SearchDataBody(company = "나쁜 곳",product = "부자가 되는 여드름 패치"))
//        searchDataBodyList.add(SearchDataBody(company = "뭐라고 할까 회사",product = "로또 당첨되는 모자"))
//        searchDataBodyList.add(SearchDataBody(company = "에이 귀찮아",product = "수면에 좋은 술"))
//        searchDataBodyList.add(SearchDataBody(company = "그냥 회사",product = "술은데 몸에 좋은 술"))
//        searchDataBodyList.add(SearchDataBody(company = "A회사",product = "아주 좋은 화장품"))
//        searchDataBodyList.add(SearchDataBody(company = "B라는 회사",product = "여드름 바로 없어지는 화장품"))
//        searchDataBodyList.add(SearchDataBody(company = "컴퍼니",product = "키가 크는 화장품"))
//        searchDataBodyList.add(SearchDataBody(company = "저기 회사",product = "이뻐지는 크림"))
//        searchDataBodyList.add(SearchDataBody(company = "나쁜 곳",product = "부자가 되는 여드름 패치"))
//        searchDataBodyList.add(SearchDataBody(company = "뭐라고 할까 회사",product = "로또 당첨되는 모자"))
//        searchDataBodyList.add(SearchDataBody(company = "에이 귀찮아",product = "수면에 좋은 술"))
//        searchDataBodyList.add(SearchDataBody(company = "그냥 회사",product = "술은데 몸에 좋은 술"))
        return SearchData(success = true, searchDataBodyList)

    }
}