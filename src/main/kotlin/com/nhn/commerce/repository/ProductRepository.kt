package com.nhn.commerce.repository

import com.nhn.commerce.model.Product
import org.apache.ibatis.annotations.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

@Mapper
interface ProductRepository: JpaRepository<Product, Long> {

    fun findAllBy(): List<Product>

    @Query("select p from Product p where p.productId = :productId")
    override fun findById(@Param("productId") productId: Long): Optional<Product>

}
