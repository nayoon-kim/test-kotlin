package com.zonzal.musinsa.domain

import jakarta.persistence.*

@Entity
@Table(name = "brand")
class Brand (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var name: String
) {
    fun updateName(name: String) {
        this.name = name
    }

    companion object {
        fun from(brandData: BrandData): Brand {
            return Brand(
                name = brandData.name,
                id = null
            )
        }
    }
}