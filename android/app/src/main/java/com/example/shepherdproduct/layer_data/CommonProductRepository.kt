package com.example.shepherdproduct.layer_data

import com.example.shepherdproduct.layer_data.datasource.RemoteDataSource
import com.example.shepherdproduct.layer_data.entity.SearchEntity
import com.example.shepherdproduct.layer_domain.ProductRepository
import com.example.shepherdproduct.layer_domain.data.SearchData
import com.example.shepherdproduct.layer_domain.data.SearchDataBody
import com.example.shepherdproduct.layer_domain.data.SearchType

class CommonProductRepository (private val remoteDataSource: RemoteDataSource):ProductRepository{
    override suspend fun search(searchText:String, searchType: SearchType): SearchData {

        val searchProduct = if(searchType == SearchType.Product){
            remoteDataSource.searchProduct(searchText)
        }else{
            remoteDataSource.searchCompany(searchText)
        }

        val searchDataList = mutableListOf<SearchDataBody>()
        // 데이터가 안온경우
        if(searchProduct == null) return SearchData(false,searchDataList)

        val items = searchProduct?.body?.items ?: null ?: return SearchData(true,searchDataList)
        for (item in items) {
            searchDataList.add(SearchDataBody(item.ENTRPS, item.PRDUCT))
        }

        return SearchData(true,searchDataList)
    }
}