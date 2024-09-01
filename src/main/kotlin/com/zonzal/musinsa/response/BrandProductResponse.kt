package com.zonzal.musinsa.response

data class BrandProductResponse(
    val categoryId: Long,
    val minBrandResponse: BrandResponse,
    val maxBrandResponse: BrandResponse
)