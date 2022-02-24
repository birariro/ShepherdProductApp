package com.example.shepherdproduct.layer_domain.data

data class SearchData(
    val success:Boolean,
    val data:List<SearchDataBody>
)
data class SearchDataBody(
    val Company:String,
    val Product:String
)
