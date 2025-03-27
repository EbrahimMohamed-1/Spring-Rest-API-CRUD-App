package com.example.springrestapicrudapp.dao;

import com.example.springrestapicrudapp.model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {
    Optional<ProductDetails> findByProductId(Integer productId);
}
