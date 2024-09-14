package com.zonzal.musinsa.service

import com.zonzal.musinsa.repository.BrandRepository
import com.zonzal.musinsa.repository.CategoryRepository
import com.zonzal.musinsa.repository.ProductRepository
import com.zonzal.musinsa.response.*

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository,
    private val brandRepository: BrandRepository
) {
    fun getLowHighCategory(): BrandProductsResponse {
        val brandId = productRepository.findLowestPriceBrandId();
        val products = productRepository.findByBrandId(brandId)
        val productsPrice = productRepository.findSumPriceByBrandId(brandId)
        val brand = brandRepository.findById(brandId)

        return BrandProductsResponse(brand.get().name, products.map { ProductResponse(it) }, productsPrice);
    }

    fun getLowestPriceProductsByCategory(): List<ProductResponse> {
        val products = productRepository.findLowestProductsGroupByCategoryId()

        return products.map {
            ProductResponse(it)
        }
    }

    fun getLowestProductsSumPrice(): Int {
        return productRepository.findLowestProductsSumPrice()
    }

    fun getMinMaxPriceProducts(categoryName: String): BrandProductResponse? {
        val categoryResult = categoryRepository.findByName(categoryName)

        if (categoryResult.isEmpty()) {
            return null
        }

        val category = categoryResult.get()
        val minProduct = productRepository.findMinPriceProductByCategoryId(category.id)
        val maxProduct = productRepository.findMaxPriceProductByCategoryId(category.id)
        return BrandProductResponse(category.id, BrandResponse(minProduct), BrandResponse(maxProduct))
    }
}