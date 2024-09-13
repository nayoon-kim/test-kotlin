package com.zonzal.musinsa.response

import com.zonzal.musinsa.domain.Brand

data class BrandDataResponse(
    val id: Long?,
    val name: String
) {
    constructor(brand: Brand): this (
        brand.id,
        brand.name
    )
}