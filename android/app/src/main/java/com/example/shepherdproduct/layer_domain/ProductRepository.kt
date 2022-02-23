package com.example.shepherdproduct.layer_domain

import com.example.shepherdproduct.layer_domain.data.SearchData
import com.example.shepherdproduct.layer_domain.data.SearchType

interface ProductRepository {
    suspend fun search(searchText:String, searchType: SearchType) :List<SearchData>
}