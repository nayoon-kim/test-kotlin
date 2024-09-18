package com.zonzal.musinsa.domain

data class BrandPrice(
    val brand: Brand,
    val price: Int
){
    companion object {
        fun of(brand: Brand, price: Int): BrandPrice {
            return BrandPrice(
                brand = brand,
                price = price
            )
        }
    }
}
