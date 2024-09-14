package com.zonzal.musinsa.response

import com.zonzal.musinsa.domain.Product

data class ProductResponse(
    val id: Long,
    val price: Int,
    val brandName: String,
    val categoryName: String
) {
    constructor(product: Product): this (
        product.id,
        product.price,
        product.brand.name,
        product.category.name
    )
}
