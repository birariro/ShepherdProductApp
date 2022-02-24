package com.example.shepherdproduct.layer_data

import com.example.shepherdproduct.layer_data.datasource.RemoteDataSource
import com.example.shepherdproduct.layer_domain.ProductRepository
import com.example.shepherdproduct.layer_domain.data.SearchData
import com.example.shepherdproduct.layer_domain.data.SearchDataBody
import com.example.shepherdproduct.layer_domain.data.SearchType

class CommonProductRepository (private val remoteDataSource: RemoteDataSource):ProductRepository{
    override suspend fun search(searchText:String, searchType: SearchType): SearchData {
        val searchProduct = remoteDataSource.searchProduct(searchText)

        val searchDataList = mutableListOf<SearchDataBody>()
        val items = searchProduct?.body?.items ?: null ?: return SearchData(false,searchDataList)
        for (item in items) {
            searchDataList.add(SearchDataBody(item.ENTRPS, item.PRDUCT))
        }

        return SearchData(true,searchDataList)
    }
}