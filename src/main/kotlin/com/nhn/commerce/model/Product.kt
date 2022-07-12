package com.nhn.commerce.model

import com.nhn.commerce.dto.GetProductDto
import com.nhn.commerce.dto.ProductDto
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Product(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val productId: Long? = null,

    private var productName: String,
    private var registerYmdt: LocalDateTime = LocalDateTime.now(),
    private var salePrice: Int,
    private var updateYmdt: LocalDateTime? = null,
){
    fun toReadProductDto(): GetProductDto {
        return GetProductDto(
            productName = productName,
            registerYmdt = registerYmdt,
            salePrice = salePrice,
            updateYmdt = updateYmdt
        )
    }

    fun createProduct(): ProductDto {
        return ProductDto(
            productName = productName,
            salePrice = salePrice
        )
    }

    fun updateProduct(productDto: ProductDto) {
        productName = productDto.productName
        salePrice = productDto.salePrice
        updateYmdt = LocalDateTime.now()
    }
}
