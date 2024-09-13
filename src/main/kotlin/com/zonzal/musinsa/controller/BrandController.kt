package com.zonzal.musinsa.controller

import com.zonzal.musinsa.domain.BrandData
import com.zonzal.musinsa.response.ApiResponse
import com.zonzal.musinsa.response.BrandDataResponse
import com.zonzal.musinsa.service.BrandService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/brands")
class BrandController(private val brandService: BrandService) {

    @PostMapping
    fun addBrand(@RequestBody brandData: BrandData): ResponseEntity<ApiResponse<BrandDataResponse>> {
        return ResponseEntity.ok(ApiResponse.success(brandService.save(brandData)))
    }

    @DeleteMapping("/{brandId}")
    fun deleteBrand(@PathVariable brandId: Long): ResponseEntity<Unit> {
        brandService.delete(brandId)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{brandId}")
    fun updateBrand(@PathVariable brandId: Long, @RequestBody brandData: BrandData): ResponseEntity<ApiResponse<BrandDataResponse>> {
        return ResponseEntity.ok(ApiResponse.success(brandService.update(brandId, brandData)))
    }
}