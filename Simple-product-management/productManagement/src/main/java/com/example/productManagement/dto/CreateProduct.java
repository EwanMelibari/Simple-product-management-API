package com.example.productManagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

// DTO class for creating products
@Data
public class CreateProduct {

    @NotNull
    private Long productId;


    @NotNull
    @NotBlank
    private String productName;

    @NotNull
    private double productPrice;

}
