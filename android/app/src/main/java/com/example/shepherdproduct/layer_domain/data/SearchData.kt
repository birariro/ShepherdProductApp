package com.example.shepherdproduct.layer_domain.data

data class SearchData(
    val success:Boolean,
    val data:List<SearchDataBody>
) : java.io.Serializable

data class SearchDataBody(
    val company:String,
    val product:String
) : java.io.Serializable
