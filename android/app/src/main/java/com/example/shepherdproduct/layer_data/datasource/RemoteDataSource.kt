package com.example.shepherdproduct.layer_data.datasource

import com.example.shepherdproduct.layer_data.entity.SearchEntity
import retrofit2.Retrofit
import java.net.URLEncoder

class RemoteDataSource(private val retrofit: Retrofit) {
    suspend fun searchProduct(ProductName:String) : SearchEntity{

        val encode = URLEncoder.encode(ProductName, "UTF-8")
        val searchProduct = retrofit.create(RetrofitDataBase::class.java)
            .searchProduct(prductName = encode)

        return  searchProduct

    }

}