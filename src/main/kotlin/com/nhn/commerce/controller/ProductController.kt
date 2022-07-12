package com.nhn.commerce.controller

import com.nhn.commerce.dto.ProductDto
import com.nhn.commerce.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(

    @Autowired
    private val productService: ProductService,
) {
    @GetMapping("/product", produces = ["application/json"])
    fun getProductList(): ResponseEntity<Any> {
        return ResponseEntity
            .ok()
            .body(productService.getProducts())
    }

    // TODO (상품 상세 조회 기능 + Exception 처리)
//    @GetMapping("/product/detail/{productId}")
//    fun getProductDetail(productDto : ProductDto)

    // TODO (상품 추가 기능)
    @PostMapping("/product/create")
    fun createProduct(@RequestBody productDto: ProductDto): ResponseEntity<Any> {
        productService.create(productDto)
        return ResponseEntity
            .ok()
            .body(true)

    }

    // TODO (상품 수정 기능 + Exception 처리)

    // TODO (상품 삭제 기능 + Exception 처리)

}
