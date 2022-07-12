package com.nhn.commerce.dto

import com.nhn.commerce.model.Product
import java.time.LocalDateTime

data class GetProductDto (
    val productName: String,
    val salePrice: Int,
    val registerYmdt: LocalDateTime,
    val updateYmdt: LocalDateTime? = null,
)

data class ProductDto (
    val productName: String,
    val salePrice: Int,
){
    fun toEntity(): Product {
        return Product(
            productName = productName,
            salePrice = salePrice,
        )
    }
}