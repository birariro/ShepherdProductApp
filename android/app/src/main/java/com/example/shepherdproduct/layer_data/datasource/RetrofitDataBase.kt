package com.example.shepherdproduct.layer_data.datasource

import com.example.shepherdproduct.layer_data.entity.SearchEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitDataBase {
    @GET("FoodFlshdErtsInfoService02/getFoodFlshdErtsList")
    suspend fun searchProduct(
        @Query("ServiceKey")serviceKey:String = "ecRUAWQCCIj7fved9BSoyYhkCrLWpUswHZ6bq5I635bB0GG76X5Mc4Wv11MWAfPz3B01eprG1KmgWX46Qlw3oA==",
        @Query("Prduct") prductName:String,
        @Query("pageNo") pageNo:Int = 1,
        @Query("type") type:String = "json",

    ) : SearchEntity

    @GET("FoodFlshdErtsInfoService02/getFoodFlshdErtsList")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    suspend fun searchCompany(
        @Query("ServiceKey")serviceKey:String = "ecRUAWQCCIj7fved9BSoyYhkCrLWpUswHZ6bq5I635bB0GG76X5Mc4Wv11MWAfPz3B01eprG1KmgWX46Qlw3oA==",
        @Query("Entrps") companyName:String,
        @Query("pageNo") pageNo:Int = 1,
        @Query("type") type:String = "json",
        ) : SearchEntity
}