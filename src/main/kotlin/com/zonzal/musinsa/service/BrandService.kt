package com.zonzal.musinsa.service

import com.zonzal.musinsa.domain.Brand
import com.zonzal.musinsa.domain.BrandData
import com.zonzal.musinsa.repository.BrandRepository
import com.zonzal.musinsa.response.BrandDataResponse
import org.springframework.stereotype.Service

@Service
class BrandService(private val brandRepository: BrandRepository) {
    fun save(brandData: BrandData): BrandDataResponse {
        val response = brandRepository.save(Brand(brandData))
        return BrandDataResponse(response)
    }

    fun delete(brandId: Long) {
        brandRepository.deleteById(brandId)
    }

    fun update(brandId: Long, brandData: BrandData): BrandDataResponse? {
        val response = brandRepository.findById(brandId)
        if (response.isEmpty()) {
            return null
        }

        val brand = response.get()
        brand.name = brandData.name
        return BrandDataResponse(brandRepository.save(brand))
    }
}