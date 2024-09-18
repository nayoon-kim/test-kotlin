package com.zonzal.musinsa.response

import com.zonzal.musinsa.domain.Product

data class ProductResponse(
    val id: Long,
    val price: Int,
    val brandName: String,
    val categoryName: String
) {
    companion object {
        fun from(product: Product): ProductResponse {
            return ProductResponse(
                id = product.id,
                price = product.price,
                brandName = product.brand.name,
                categoryName = product.category.name
            )
        }
    }

}
