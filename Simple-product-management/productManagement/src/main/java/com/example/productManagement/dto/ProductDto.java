package com.example.productManagement.dto;

import com.example.productManagement.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {

    @NotNull
    @NotEmpty
    private Long productId;

    @NotNull
    @NotBlank
    private String productName;


    @NotNull
    @NotEmpty
    private double productPrice;

    public ProductDto(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
    }

}
