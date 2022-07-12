package com.nhn.commerce.service

import com.nhn.commerce.dto.GetProductDto
import com.nhn.commerce.dto.ProductDto
import com.nhn.commerce.dto.getProductDto
import com.nhn.commerce.repository.ProductRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.ui.ModelMap
import javax.transaction.Transactional

@Service
class ProductService {

    @Autowired
    private lateinit var productRepository: ProductRepository

    fun getProducts(): List<GetProductDto> {
        val product = productRepository.findAll()
        return product
    }

    @Transactional
    fun create(productDto: ProductDto): ProductDto {
        val product = productRepository.save(productDto.toEntity())
        return product.createProduct()
    }
}
