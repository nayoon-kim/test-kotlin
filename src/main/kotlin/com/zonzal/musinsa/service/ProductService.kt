package com.zonzal.musinsa.service

import com.zonzal.musinsa.repository.CategoryRepository
import com.zonzal.musinsa.repository.ProductRepository
import com.zonzal.musinsa.response.BrandProductResponse
import com.zonzal.musinsa.response.BrandResponse
import com.zonzal.musinsa.response.ProductResponse
import com.zonzal.musinsa.response.ProductsResponse

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
) {
    fun getLowHighCategory(): ProductsResponse {
        val brandId = productRepository.findLowestPriceBrandId();
        val products = productRepository.findByBrandId(brandId)
        val productsPrice = productRepository.findSumPriceByBrandId(brandId)

        return ProductsResponse(products.map { ProductResponse(it) }, productsPrice)
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

    fun getMinMaxPriceProducts(categoryId: Long): BrandProductResponse {
        val minProduct = productRepository.findMinPriceProductByCategoryId(categoryId)
        val maxProduct = productRepository.findMaxPriceProductByCategoryId(categoryId)
        return BrandProductResponse(categoryId, BrandResponse(minProduct), BrandResponse(maxProduct))
    }
}