package com.zonzal.musinsa.response

import com.zonzal.musinsa.domain.Brand

data class BrandDataResponse(
    val id: Long?,
    val name: String?
) {

    companion object {
        fun defaultResponse(): BrandDataResponse {
            return BrandDataResponse(
                id = null,
                name = null
            )
        }

        fun from(brand: Brand): BrandDataResponse {
            return BrandDataResponse(
                id = brand.id,
                name = brand.name
            )
        }
    }
}