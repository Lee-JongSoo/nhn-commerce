package com.nhn.commerce.repository

import com.nhn.commerce.model.Product
import org.apache.ibatis.annotations.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ProductRepository: JpaRepository<Product, Long> {

    fun findAllBy(): List<Product>

    @Query("select p from Product p where p.productId = :productId")
    override fun findById(@Param("productId") productId: Long): Optional<Product>

    /**
     * mybatis를 이용한 쿼리문 작성
     */
    @Select("SELECT * FROM product")
    fun findProductList(): List<Product>

    @Select("SELECT * FROM product WHERE product_Id = #{productId}")
    fun findProductDetail(productId: Int): Product

    @Select(
        "INSERT INTO product (product_Id, product_name, sale_price, register_ymdt, update_ymdt) " +
                "VALUES(#{productId}, #{productName}, #{salePrice}, #{localDateTime}, #{localDateTime})"
    )
    fun addProduct(productId: Int, productName: String, salePrice: Int, localDateTime: LocalDateTime): List<Product>

    @Select("Update product SET sale_price=#{salePrice}, product_name=#{productName},update_ymdt=#{localDateTime} where WHERE product_Id=#{productId}")
    fun updateProduct(productId: Int, productName: String, salePrice: Int, localDateTime: LocalDateTime): List<Product>

    @Select("Delete from product where product_Id=#{productId}")
    fun deleteProduct(productId: Int): List<Product>
}
