package com.zonzal.musinsa.response

import com.zonzal.musinsa.domain.Product

data class BrandResponse(
    val brandId: Long,
    val price: Int
) {
    constructor(product: Product): this (
        product.brandId,
        product.price
    )
}