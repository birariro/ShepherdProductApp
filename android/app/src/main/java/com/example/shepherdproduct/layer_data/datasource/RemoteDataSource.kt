package com.example.shepherdproduct.layer_data.datasource

import android.util.Log
import com.example.shepherdproduct.layer_data.entity.SearchEntity
import retrofit2.Retrofit
import java.lang.Exception
import java.net.URLEncoder

class RemoteDataSource(private val retrofit: Retrofit) {
    //todo 여기 flow 로 변경하자
    suspend fun searchProduct(productName:String) : SearchEntity?{
        return try{
            val encode = URLEncoder.encode(productName, "UTF-8")
            val searchProduct = retrofit.create(RetrofitDataBase::class.java)
                .searchProduct(prductName = encode)
            Log.d("RemoteDataSource","searchProduct ${searchProduct}")
            searchProduct
        }catch (e:Exception){
            Log.d("RemoteDataSource","e ${e.message}")
            null
        }


    }

}