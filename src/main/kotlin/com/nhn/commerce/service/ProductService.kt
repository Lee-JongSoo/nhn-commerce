package com.nhn.commerce.service

import com.nhn.commerce.dto.GetProductDto
import com.nhn.commerce.dto.ProductDto
import com.nhn.commerce.model.Product
import com.nhn.commerce.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import javax.transaction.Transactional

@Service
class ProductService {

    @Autowired
    private lateinit var productRepository: ProductRepository

    fun getProducts(): List<GetProductDto> {
        val product = productRepository.findAllBy()
        return product.stream().map {
            it.toReadProductDto()
        }.collect(Collectors.toList())
    }

    fun getProductOne(productId: Long): List<GetProductDto> {
        val product = productRepository.findById(productId)
        return product.stream().map {
            it.toReadProductDto()
        }.collect(Collectors.toList())
    }

    @Transactional
    fun create(productDto: ProductDto): ProductDto {
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
