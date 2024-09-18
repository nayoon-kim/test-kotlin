package com.zonzal.musinsa.service

import com.zonzal.musinsa.domain.Brand
import com.zonzal.musinsa.domain.BrandData
import com.zonzal.musinsa.repository.BrandRepository
import com.zonzal.musinsa.response.BrandDataResponse
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BrandService(
    private val brandRepository: BrandRepository
) {
    @Transactional
    fun save(brandData: BrandData): BrandDataResponse {
        val brand = brandRepository.save(Brand.from(brandData))
        return BrandDataResponse.from(brand)
    }

    @Transactional
    fun delete(brandId: Long) {
        brandRepository.deleteById(brandId)
    }

    @Transactional
    fun update(brandId: Long, brandData: BrandData): BrandDataResponse? {
        val brand = brandRepository.findByIdOrNull(brandId)
            ?: return BrandDataResponse.defaultResponse()

        brand.updateName(brandData.name)

        return BrandDataResponse.defaultResponse()
    }
}