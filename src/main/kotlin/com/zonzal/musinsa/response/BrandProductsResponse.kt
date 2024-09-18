package com.zonzal.musinsa.response

data class BrandProductsResponse (
    val brandName: String?,
    val products: List<ProductResponse>?,
    val sum: Int?
) {
    companion object {
        fun defaultResponse(): BrandProductsResponse {
            return BrandProductsResponse(
                brandName = null,
                products = null,
                sum = null
            )
        }

        fun of(name: String, products: List<ProductResponse>, price: Int): BrandProductsResponse {
            return BrandProductsResponse(
                brandName = name,
                products = products,
                sum = price
            )
        }
    }
}