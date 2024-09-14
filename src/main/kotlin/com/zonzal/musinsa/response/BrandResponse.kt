package com.zonzal.musinsa.response

import com.zonzal.musinsa.domain.Product

data class BrandResponse(
    val brandName: String,
    val price: Int
) {
    constructor(product: Product): this (
        product.brand.name,
        product.price
    )
}