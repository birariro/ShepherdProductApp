package com.example.shepherdproduct.layer_data

import com.example.shepherdproduct.layer_data.datasource.RemoteDataSource
import com.example.shepherdproduct.layer_domain.ProductRepository
import com.example.shepherdproduct.layer_domain.data.SearchType

class CommonProductRepository (private val remoteDataSource: RemoteDataSource):ProductRepository{
    override suspend fun search(searchText:String, searchType: SearchType): String {
        return remoteDataSource.searchProduct(searchText)
    }
}