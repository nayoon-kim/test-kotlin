package com.zonzal.musinsa.controller

import com.zonzal.musinsa.service.ProductService
import com.zonzal.musinsa.response.ApiResponse
import com.zonzal.musinsa.response.ProductResponse
import com.zonzal.musinsa.response.ProductsResponse
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {

    @GetMapping("/lowest-category")
    fun getLowestPriceProductsByCategory():ResponseEntity<ApiResponse<ProductsResponse>>
    {
        val response = productService.getLowestPriceProductsByCategory()
        val price = productService.getLowestProductsSumPrice()

        return ResponseEntity.ok(ApiResponse.success(ProductsResponse(response, price)))
    }

    @GetMapping("/low-high-category")
    fun getLowHighCategory(): ResponseEntity<ApiResponse<ProductsResponse>> {
        return ResponseEntity.ok(ApiResponse.success(productService.getLowHighCategory()))
    }
}