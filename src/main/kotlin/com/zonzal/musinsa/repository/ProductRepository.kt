package com.zonzal.musinsa.repository

import com.zonzal.musinsa.domain.Brand
import com.zonzal.musinsa.domain.Category
import com.zonzal.musinsa.domain.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long> {
    fun findTopByCategoryOrderByPrice(category: Category): Product

    fun findByBrand(brand: Brand): List<Product>

    @Query("select sum(b.price) from product b where b.brand = :brand")
    fun findSumPriceByBrand(@Param("brand") brand: Brand): Int

    @Query("select id, price, brand_id, category_id from product " +
            "where category_id = :category_id order by price limit 1", nativeQuery=true)
    fun findMinPriceProductByCategoryId(@Param("category_id") categoryId: Long): Product

    @Query("select id, price, brand_id, category_id from product " +
            "where category_id = :category_id order by price desc limit 1", nativeQuery=true)
    fun findMaxPriceProductByCategoryId(@Param("category_id") categoryId: Long): Product
}