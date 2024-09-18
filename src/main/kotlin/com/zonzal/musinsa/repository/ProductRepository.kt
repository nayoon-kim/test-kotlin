package com.zonzal.musinsa.repository

import com.zonzal.musinsa.domain.Brand
import com.zonzal.musinsa.domain.Category
import com.zonzal.musinsa.domain.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long> {
    fun findTopByCategoryOrderByPrice(category: Category): Product
    fun findTopByCategoryOrderByPriceDesc(category: Category): Product
    fun findByBrand(brand: Brand): List<Product>
    fun findAllByBrand(brand: Brand): List<Product>
}