package com.zonzal.musinsa.repository

import com.zonzal.musinsa.domain.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository: JpaRepository<Category, Long> {
    fun findByName(name: String): Category?
}
