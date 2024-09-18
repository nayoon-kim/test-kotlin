package com.zonzal.musinsa.response

data class BrandProductResponse(
    val categoryId: Long?,
    val minBrandResponse: BrandResponse?,
    val maxBrandResponse: BrandResponse?
) {
    companion object {
        fun defaultResponse(): BrandProductResponse {
            return BrandProductResponse(
                categoryId = null,
                maxBrandResponse = null,
                minBrandResponse = null
            )
        }
    }

}