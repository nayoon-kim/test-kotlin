package com.zonzal.musinsa.service

import com.zonzal.musinsa.domain.Brand
import com.zonzal.musinsa.domain.BrandData
import com.zonzal.musinsa.repository.BrandRepository
import org.springframework.stereotype.Service

@Service
class BrandService(private val brandRepository: BrandRepository) {
    fun save(brand: BrandData): Brand {
        return brandRepository.save(Brand(null, brand.name))
    }

    fun delete(brandId: Long) {
        return brandRepository.deleteById(brandId)
    }

    fun update(brand: Brand): Brand? {
        if (brand.id?.let { brandRepository.existsById(it) } == true) {
            return brandRepository.save(brand)
        }
        return null
    }
}