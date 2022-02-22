package com.example.shepherdproduct.layer_domain.usecase

import com.example.shepherdproduct.layer_domain.ProductRepository
import com.example.shepherdproduct.layer_domain.data.SearchType

class SearchUseCase(private val productRepository: ProductRepository) {
    suspend fun execute(searchText:String, searchType:SearchType) : String{
        return productRepository.search(searchText,searchType)
    }
}