package com.zonzal.musinsa.response

import com.zonzal.musinsa.domain.Product

data class ProductsPriceResponse (
    val productResponses: List<ProductResponse>,
    val sum: Int
) {
    companion object {
        fun of(products: List<Product>, price: Int): ProductsPriceResponse {
            return ProductsPriceResponse(
                productResponses = products.map {
                    ProductResponse.from(it)
                },
                sum = price
            )
        }
    }
}