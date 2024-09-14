package com.zonzal.musinsa.domain

import jakarta.persistence.*

@Entity
@Table(name = "brand")
class Brand (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column
    var name: String
) {
    constructor(brandData: BrandData): this (
        -1,
        brandData.name
    )
}