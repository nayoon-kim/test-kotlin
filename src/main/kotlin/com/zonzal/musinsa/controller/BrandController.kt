package com.zonzal.musinsa.controller

import com.zonzal.musinsa.domain.Brand
import com.zonzal.musinsa.domain.BrandData
import com.zonzal.musinsa.service.BrandService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/brands")
class BrandController(private val brandService: BrandService) {

    @PostMapping
    fun addBrand(@RequestBody brandData: BrandData): Brand {
        return brandService.save(brandData)
    }

    @DeleteMapping("/{brandId}")
    fun deleteBrand(@PathVariable brandId: Long) {
        return brandService.delete(brandId)
    }

    @PutMapping
    fun updateBrand(@RequestBody brand: Brand): Brand? {
        return brandService.update(brand)
    }
}