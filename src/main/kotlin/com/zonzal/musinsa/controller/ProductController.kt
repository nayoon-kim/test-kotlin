package com.zonzal.musinsa.controller

import com.zonzal.musinsa.response.*
import com.zonzal.musinsa.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {

    @GetMapping("/lowest-category")
    fun getLowestPriceProductsByCategory():ResponseEntity<ApiResponse<ProductsPriceResponse>> {
        val products = productService.getLowestPriceProductsByCategory()
        val price = productService.getLowestProductsSumPrice()

        return ResponseEntity.ok(ApiResponse.success(ProductsPriceResponse(products, price)))
    }

    @GetMapping("/low-high-category")
    fun getLowHighCategory(): ResponseEntity<ApiResponse<BrandProductsResponse>> {
        return ResponseEntity.ok(ApiResponse.success(productService.getLowHighCategory()))
    }
}