package com.nhn.commerce.repository

import com.nhn.commerce.model.Product
import org.apache.ibatis.annotations.*
import org.springframework.data.jpa.repository.JpaRepository

@Mapper
interface ProductRepository: JpaRepository<Product, Long> {

    fun findAllBy(): List<Product>


}
