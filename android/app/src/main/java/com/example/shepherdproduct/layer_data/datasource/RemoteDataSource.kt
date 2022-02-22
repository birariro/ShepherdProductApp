package com.example.shepherdproduct.layer_data.datasource

import android.util.Log
import com.example.shepherdproduct.layer_data.entity.SearchEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import java.net.URLEncoder

class RemoteDataSource(private val retrofit: Retrofit) {
    suspend fun searchProduct(ProductName:String) : String{
        try{
            val encode = URLEncoder.encode(ProductName, "UTF-8")
            val searchProduct = retrofit.create(RetrofitDataBase::class.java)
                .searchProduct(prductName = encode)
            Log.d("TEST","TEST searchProduct :${searchProduct.toString()}")
            val items = searchProduct.body.items
            for (item in items) {
                Log.d("TEST","TEST searchProduct :${item}")
            }


        }
        catch (e : Exception){
            Log.d("TEST","TEST e :${e.message}")

        }
       return ""
    }

}