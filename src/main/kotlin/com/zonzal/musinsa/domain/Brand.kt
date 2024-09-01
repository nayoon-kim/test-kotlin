package com.zonzal.musinsa.domain

import jakarta.persistence.*

@Entity
@Table(name = "brand")
class Brand (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column
    var name: String
)