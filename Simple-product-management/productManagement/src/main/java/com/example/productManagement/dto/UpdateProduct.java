package com.example.productManagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
// DTO class to update the product
@Data
public class UpdateProduct {

    @NotNull
    private Long productId;

    @NotNull
    @NotBlank
    private String productName;

    @NotNull
    private double productPrice;


}
