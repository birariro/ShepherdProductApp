package com.example.shepherdproduct.layer_data.datasource

import android.util.Log
import com.example.shepherdproduct.layer_data.entity.SearchEntity
import retrofit2.Retrofit
import java.lang.Exception
import java.net.URLEncoder

class RemoteDataSource(private val retrofit: Retrofit) {

    suspend fun searchProduct(productName:String) : SearchEntity?{
        Log.d("RemoteDataSource","searchProduct 시작")
        return try{
            val searchProduct = retrofit.create(RetrofitDataBase::class.java)
                .searchProduct(prductName = productName)
            Log.d("RemoteDataSource","searchProduct ${searchProduct}")
            searchProduct
        }catch (e:Exception){
            Log.d("RemoteDataSource","e ${e.message}")
            null
        }


    }

    suspend fun searchCompany(companyName:String) : SearchEntity?{
        Log.d("RemoteDataSource","searchCompany 시작")
        return try{
            val searchCompany = retrofit.create(RetrofitDataBase::class.java)
                .searchCompany(companyName = companyName)
            Log.d("RemoteDataSource","searchCompany ${searchCompany}")
            searchCompany
        }catch (e:Exception){
            Log.d("RemoteDataSource","e ${e.message}")
            null
        }


    }

}