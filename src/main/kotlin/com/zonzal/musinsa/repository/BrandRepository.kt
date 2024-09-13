package com.zonzal.musinsa.repository

import com.zonzal.musinsa.domain.Brand
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BrandRepository : JpaRepository<Brand, Long> {
    override fun findById(id: Long): Optional<Brand>
}