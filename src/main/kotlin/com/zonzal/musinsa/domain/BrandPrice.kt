package com.zonzal.musinsa.domain

data class BrandPrice(
    val brand: Brand,
    val price: Int
){
    companion object {
        fun of(brand: Brand, products: List<Product>): BrandPrice {
            return BrandPrice(
                brand = brand,
                price = products.sumOf { it.price }
            )
        }
    }
}
