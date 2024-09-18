package com.zonzal.musinsa.controller

import com.zonzal.musinsa.response.*
import com.zonzal.musinsa.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {

    @GetMapping("/lowest-category")
    fun getLowestPriceProductsByCategory():ResponseEntity<ApiResponse<ProductsPriceResponse>> {
        val result = productService.getLowestPriceProductsByCategory()
        return ResponseEntity.ok(ApiResponse.success(result))
    }

    @GetMapping("/low-high-category")
    fun getLowHighCategory(): ResponseEntity<ApiResponse<BrandProductsResponse>> {
        val result = productService.getLowHighCategory()
        return ResponseEntity.ok(ApiResponse.success(result))
    }

    @GetMapping("/min-max-brand-price/{categoryName}")
    fun getMinMaxPrice(@PathVariable categoryName: String): ResponseEntity<ApiResponse<BrandProductResponse>> {
        val result = productService.getMinMaxPriceProducts(categoryName)
        return ResponseEntity.ok(ApiResponse.success(result))
    }
}