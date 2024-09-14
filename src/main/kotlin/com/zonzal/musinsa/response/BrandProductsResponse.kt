package com.zonzal.musinsa.response

data class BrandProductsResponse (
    val brandName: String,
    val products: List<ProductResponse>,
    val sum: Int
)