package com.zonzal.musinsa.service

import com.zonzal.musinsa.domain.BrandPrice
import com.zonzal.musinsa.repository.BrandRepository
import com.zonzal.musinsa.repository.CategoryRepository
import com.zonzal.musinsa.repository.ProductRepository
import com.zonzal.musinsa.response.*

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository,
    private val brandRepository: BrandRepository
) {
    @Transactional(readOnly = true)
    fun getLowHighCategory(): BrandProductsResponse {
        val brands = brandRepository.findAll()
        val minPriceBrand = brands.map {
            BrandPrice.of(it, productRepository.findAllByBrand(it))
        }.minBy { it.price }

        val products = productRepository.findByBrand(minPriceBrand.brand)

        return BrandProductsResponse
            .of(minPriceBrand.brand.name, products.map { ProductResponse.from(it) }, minPriceBrand.price);
    }

    @Transactional(readOnly = true)
    fun getLowestPriceProductsByCategory(): ProductsPriceResponse {
        val categories = categoryRepository.findAll()
        val products = categories.map {
            productRepository.findTopByCategoryOrderByPrice(it)
        }
        val sum = products.sumOf { it.price }

        return ProductsPriceResponse.of(products, sum)
    }

    @Transactional(readOnly = true)
    fun getMinMaxPriceProducts(categoryName: String): BrandProductResponse? {
        val category = categoryRepository.findByName(categoryName)
            ?: return BrandProductResponse.defaultResponse()

        val minProduct = productRepository.findTopByCategoryOrderByPrice(category)
        val maxProduct = productRepository.findTopByCategoryOrderByPriceDesc(category)
        return BrandProductResponse(category.name, BrandResponse(minProduct), BrandResponse(maxProduct))
    }
}