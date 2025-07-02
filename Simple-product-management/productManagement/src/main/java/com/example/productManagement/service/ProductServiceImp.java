package com.example.productManagement.service;

import com.example.productManagement.dao.ProductRepository;
import com.example.productManagement.dto.CreateProduct;
import com.example.productManagement.dto.ProductDto;
import com.example.productManagement.dto.UpdateProduct;
import com.example.productManagement.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductDto convertToDto(Product product) {
        if (product == null) {
            return null;
        }
        return new ProductDto(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.deleteById(product.getProductId());
    }

    @Override
    public boolean updateProduct(UpdateProduct product) throws Exception {
        // will continue
        return false;
    }

    @Override
    public int createProduct(CreateProduct product) throws Exception {
        // will continue
        return 0;
    }

    @Override
    public List<ProductDto> findAllProducts() throws Exception {

        List<Product> products = productRepository.findAll();

        return products.stream().map(this::convertToDto).collect(Collectors.toList());
    }



}
