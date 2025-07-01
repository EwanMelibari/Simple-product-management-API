package com.example.productManagement.service;

import com.example.productManagement.dto.CreateProduct;
import com.example.productManagement.dto.UpdateProduct;
import com.example.productManagement.model.Product;

public interface ProductService {

    public void deleteProduct(Product product) throws Exception;

    public boolean updateProduct(UpdateProduct product) throws Exception;

    public int createProduct(CreateProduct product) throws Exception;

}
