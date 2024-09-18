package com.zonzal.musinsa.response

data class BrandProductResponse(
    val categoryName: String?,
    val minBrandResponse: BrandResponse?,
    val maxBrandResponse: BrandResponse?
) {
    companion object {
        fun defaultResponse(): BrandProductResponse {
            return BrandProductResponse(
                categoryName = null,
                maxBrandResponse = null,
                minBrandResponse = null
            )
        }
    }

}