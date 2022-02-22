package com.example.shepherdproduct.layer_data.entity

data class SearchEntity (
    val header: Header,
    val body: Body
)

data class Body (
    val pageNo: Long,
    val totalCount: Long,
    val numOfRows: Long,
    val items: List<Item>
)

data class Item (
    val entrps: String,
    val prduct: String,
    val dspsDt: String? = null
)

data class Header (
    val resultCode: String,
    val resultMsg: String
)
