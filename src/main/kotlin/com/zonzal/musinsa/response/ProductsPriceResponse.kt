package com.zonzal.musinsa.response

data class ProductsPriceResponse (
    val products: List<ProductResponse>,
    val sum: Int
)