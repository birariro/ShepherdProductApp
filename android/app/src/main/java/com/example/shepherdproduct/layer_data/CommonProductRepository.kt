package com.example.shepherdproduct.layer_data

import com.example.shepherdproduct.layer_data.datasource.RemoteDataSource
import com.example.shepherdproduct.layer_domain.ProductRepository
import com.example.shepherdproduct.layer_domain.data.SearchData
import com.example.shepherdproduct.layer_domain.data.SearchType

class CommonProductRepository (private val remoteDataSource: RemoteDataSource):ProductRepository{
    override suspend fun search(searchText:String, searchType: SearchType): List<SearchData> {
        val searchProduct = remoteDataSource.searchProduct(searchText)

        val searchDataList = mutableListOf<SearchData>()
        val items = searchProduct?.body?.items ?: return searchDataList

        for (item in searchProduct.body.items) {
            searchDataList.add(SearchData(item.ENTRPS, item.PRDUCT))
        }

        return searchDataList
    }
}