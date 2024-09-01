package com.zonzal.musinsa.response

import com.zonzal.musinsa.domain.Product

data class ProductResponse(
    val id: Long,
    val price: Int,
    val brandId: Long?,
    val categoryId: Long?
) {
    constructor(product: Product): this (
        product.id,
        product.price,
        product.brandId,
        product.categoryId
    )
}
