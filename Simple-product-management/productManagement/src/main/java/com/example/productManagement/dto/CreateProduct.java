package com.example.productManagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateProduct {

    @NotEmpty
    @NotNull
    private long productID;

    @NotNull
    @NotBlank
    private String productName;


}
