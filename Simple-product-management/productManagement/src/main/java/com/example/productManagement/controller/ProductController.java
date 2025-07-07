package com.example.productManagement.controller;

import com.example.productManagement.dto.CreateProduct;
import com.example.productManagement.dto.ProductDto;
import com.example.productManagement.dto.UpdateProduct;
import com.example.productManagement.model.Product;
import com.example.productManagement.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/get")
    public ResponseEntity<List<ProductDto>> getAllProducts() throws Exception {
        List<ProductDto> products = productService.findAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/product/add")
    public ResponseEntity<Object> addProduct(@Valid @RequestBody CreateProduct product) throws Exception {
        Long productId = productService.createProduct(product);
        String id = String.valueOf(productId);
        return ResponseEntity.status(201).header("productId", id).build();
    }

    @PutMapping("/product/update")
    public ResponseEntity<Object> updateProduct(@Valid @RequestBody UpdateProduct product) throws Exception {
        boolean isResult = productService.updateProduct(product);
        String result = String.valueOf(isResult);
        return ResponseEntity.status(200).header("isResult", result).build();
    }

    @DeleteMapping("/product/delete")
    public ResponseEntity<Object> deleteProduct(@Valid @RequestBody Product product){
        productService.deleteProduct(product);
        return ResponseEntity.status(204).build();
    }

}
