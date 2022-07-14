package com.nhn.commerce.controller

import com.nhn.commerce.dto.ProductDto
import com.nhn.commerce.model.Product
import com.nhn.commerce.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.sql.DriverManager.println
import java.time.LocalDateTime
import javax.print.attribute.standard.Media

@Controller
class ProductController(

    @Autowired
    private val productService: ProductService,
) {
    @GetMapping("/product")
    fun getProductList(model: Model): String {
        model.addAttribute("productList", productService.findProductList())
        model.addAttribute("product", Product(0,"", LocalDateTime.now(),0,null))
        return "product"
    }

    // TODO (상품 상세 조회 기능 + Exception 처리)
    @GetMapping("/product/{productId}")
    fun getProductDetail(@PathVariable(name = "productId") productId: Long, model: Model): String {
        model.addAttribute("productDetail", productService.getProductOne(productId))
        return "productDetail"
    }

    // TODO (상품 추가 기능)
    @PostMapping("/product")
    fun createProduct(productDto: ProductDto, model: Model): String {
        model.addAttribute("product", productService.create(productDto))
        return getProductList(model)
    }

    // 상품 수정 페이지
    @GetMapping("/product/update/{productId}")
    fun getProductDetailUpdate(@PathVariable(name = "productId") productId: Long, model: Model): String {
        model.addAttribute("product", productService.getProductOne(productId))
        return "productUpdate"
    }

    // TODO (상품 수정 기능 + Exception 처리)
    @PostMapping("/product/update/{productId}")
    fun updateProduct(
        @PathVariable("productId")  productId: Long,
        productDto: ProductDto,
        model: Model
    ): String {
        model.addAttribute("product", productService.update(productId, productDto))
        return "redirect:/product"
    }

    // TODO (상품 삭제 기능 + Exception 처리)
    @GetMapping("/delete/{productId}")
    fun deleteProduct(@PathVariable("productId") productId: Long): String {
        productService.delete(productId)
        return "redirect:/product"
    }

}
