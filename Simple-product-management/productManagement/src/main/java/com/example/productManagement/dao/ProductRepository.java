package com.example.productManagement.dao;

import com.example.productManagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {

    Optional<Product> findByProductIdAndProductNameAndProductPrice(Integer productId, String productName, double productPrice) throws Exception;

}
