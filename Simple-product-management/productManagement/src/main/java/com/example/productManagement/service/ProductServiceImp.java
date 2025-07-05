package com.example.productManagement.service;

import com.example.productManagement.dao.ProductRepository;
import com.example.productManagement.dto.CreateProduct;
import com.example.productManagement.dto.ProductDto;
import com.example.productManagement.dto.UpdateProduct;
import com.example.productManagement.exception.BadRequestException;
import com.example.productManagement.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

        Optional<Product> isExist = productRepository.findByProductIdAndProductNameAndProductPrice(product.getProductId(),
                                                                                                   product.getProductName(),
                                                                                                   product.getProductPrice());

        if (isExist.isEmpty()){
            throw new BadRequestException("Product not found or not exist");
        }

        Product existingProduct = isExist.get();
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductPrice(product.getProductPrice());

        productRepository.save(existingProduct);

        return true;
    }

    @Override
    public Long createProduct(CreateProduct product) throws BadRequestException {
        Optional<Product> foundProduct = productRepository.findById(product.getProductId());

        if (foundProduct.isPresent()){
            throw new BadRequestException("Product already exists: " + product.getProductId());
        }
        Product newProduct = new Product();
        newProduct.setProductId(product.getProductId());
        newProduct.setProductName(product.getProductName());
        newProduct.setProductPrice(product.getProductPrice());

        productRepository.save(newProduct);

        return newProduct.getProductId();
    }

    @Override
    public List<ProductDto> findAllProducts() throws Exception {

        List<Product> products = productRepository.findAll();

        return products.stream().map(this::convertToDto).collect(Collectors.toList());
    }



}
