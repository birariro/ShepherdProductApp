package com.example.shepherdproduct.layer_data.entity

import kotlinx.serialization.Serializable

@Serializable
data class SearchEntity (
    val header: Header,
    val body: Body
)

data class Body (
    val pageNo: Long,
    val totalCount: Long,
    val numOfRows: Long,
    val items: MutableList<Item>
)

data class Item (
    val ENTRPS: String,
    val PRDUCT: String,
    val DSPS_DT: String? = null
)

data class Header (
    val resultCode: String,
    val resultMsg: String
)
