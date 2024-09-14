package com.zonzal.musinsa.domain

import jakarta.persistence.*;

@Entity
@Table(name = "product")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    @Column
    var price: Int,
    @ManyToOne
    @JoinColumn(name = "brand_id")
    var brand: Brand,
    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: Category,
)