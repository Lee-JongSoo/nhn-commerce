package com.nhn.commerce.service

import com.nhn.commerce.dto.ProductDto
import com.nhn.commerce.model.Product
import com.nhn.commerce.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.DriverManager.println
import javax.transaction.Transactional

@Service
class ProductService {

    @Autowired
    private lateinit var productRepository: ProductRepository

    fun findProductList(): List<Product> = productRepository.findAllBy()

    fun getProductOne(productId: Long): Product {
        return productRepository.findById(productId).get()
    }

    @Transactional
    fun create(productDto: ProductDto): ProductDto {
        if (productDto.salePrice < 0) {
            throw Exception("가격은 음수가 될 수 없습니다.")
        }
        val product = productRepository.save(productDto.toEntity())
        return product.createProduct()
    }

    @Transactional
    fun delete(productId: Long) {
        productRepository.deleteById(productId)
    }

    @Transactional
    fun update(productId: Long, productDto: ProductDto): Product {
        val product = productRepository.findById(productId).get()
        product.updateProduct(productDto)
        return product
    }

}
