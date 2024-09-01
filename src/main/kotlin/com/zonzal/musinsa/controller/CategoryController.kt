package com.zonzal.musinsa.controller

import com.zonzal.musinsa.response.ApiResponse
import com.zonzal.musinsa.response.BrandProductResponse
import com.zonzal.musinsa.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categories")
class CategoryController(private val productService: ProductService) {

    @GetMapping("/min-max-brand-price/{categoryId}")
    fun getMinMaxPrice(@PathVariable categoryId: Long,): ResponseEntity<ApiResponse<BrandProductResponse>> {
        val response = productService.getMinMaxPriceProducts(categoryId)
        return ResponseEntity.ok(ApiResponse.success(response))
    }
}