package com.example.productManagement.service;

import com.example.productManagement.dto.CreateProduct;
import com.example.productManagement.dto.ProductDto;
import com.example.productManagement.dto.UpdateProduct;
import com.example.productManagement.model.Product;

import java.util.List;

public interface ProductService {

    // To delete a product
    public void deleteProduct(Product product);

    // To update a specified product
    public boolean updateProduct(UpdateProduct product) throws Exception;

    // For creating a product
    public Long createProduct(CreateProduct product) throws Exception;

    // To get all the products
    public List<ProductDto> findAllProducts() throws Exception;

}
