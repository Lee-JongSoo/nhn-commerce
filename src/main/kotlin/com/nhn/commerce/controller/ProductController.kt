package com.nhn.commerce.controller

import com.nhn.commerce.dto.ProductDto
import com.nhn.commerce.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(

    @Autowired
    private val productService: ProductService,
) {
    @GetMapping("/product")
    fun getProductList(): ResponseEntity<Any> {
        return ResponseEntity.ok()
            .body(productService.getProducts())
    }

    // TODO (상품 상세 조회 기능 + Exception 처리)
    @GetMapping("/product/detail/{productId}")
    fun getProductDetail(@PathVariable("productId") productId: Long): ResponseEntity<Any> {
        return ResponseEntity.ok()
            .body(productService.getProductOne(productId))

    }

    // TODO (상품 추가 기능)
    @PostMapping("/product/create")
    fun createProduct(@RequestBody productDto: ProductDto): ResponseEntity<Any> {
        productService.create(productDto)
        return ResponseEntity.ok().body(true)

    }

    // TODO (상품 수정 기능 + Exception 처리)
    @PutMapping("/product/update/{productId}")
    fun updateProduct(
        @PathVariable("productId")  productId: Long,
        @RequestBody productDto: ProductDto
    ): ResponseEntity<Any> {
        val product = productService.update(productId, productDto)
        return ResponseEntity.ok().body(true)
    }

    // TODO (상품 삭제 기능 + Exception 처리)
    @DeleteMapping("/product/delete/{productId}")
    fun deleteProduct(@PathVariable("productId") productId: Long): ResponseEntity<Any> {
        productService.delete(productId)
        return ResponseEntity.ok().body(true)
    }

}
