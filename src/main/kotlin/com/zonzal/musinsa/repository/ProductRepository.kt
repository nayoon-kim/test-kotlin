package com.zonzal.musinsa.repository

import com.zonzal.musinsa.domain.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long> {
    @Query("select p.id, p.price, p.brand_id, p.category_id " +
            "from product p " +
            "join (select a.category_id, min(a.price) price from product a group by a.category_id) b " +
            "on p.category_id = b.category_id and p.price = b.price order by p.category_id", nativeQuery=true)
    fun findLowestProductsGroupByCategoryId(): List<Product>

    @Query("select sum(b.price) " +
            "from (select a.category_id, min(a.price) price " +
            "from product a group by a.category_id) b ", nativeQuery=true)
    fun findLowestProductsSumPrice(): Int

    @Query("select brand_id " +
            "from (select a.brand_id brand_id, sum(a.price) price from product a group by a.brand_id) b " +
            "order by price limit 1", nativeQuery=true)
    fun findLowestPriceBrandId(): Long

    fun findByBrandId(brandId: Long): List<Product>
    @Query("select sum(b.price) from product b where b.brand_id = :brand_id", nativeQuery=true)
    fun findSumPriceByBrandId(@Param("brand_id") brandId: Long): Int

    @Query("select id, price, brand_id, category_id from product " +
            "where category_id = :category_id order by price limit 1", nativeQuery=true)
    fun findMinPriceProductByCategoryId(@Param("category_id") categoryId: Long): Product

    @Query("select id, price, brand_id, category_id from product " +
            "where category_id = :category_id order by price desc limit 1", nativeQuery=true)
    fun findMaxPriceProductByCategoryId(@Param("category_id") categoryId: Long): Product
}