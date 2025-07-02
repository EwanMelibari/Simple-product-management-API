package com.example.productManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    // the ID of the product
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long productId;

    // the name of the product
    @Column
    @NotNull
    @NotBlank
    private String productName;

    // the price
    @Column
    @NotNull
    private double productPrice;

}
