package com.example.springrestapicrudapp.dao;

import com.example.springrestapicrudapp.model.Product;
import com.example.springrestapicrudapp.model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ProductRepository extends JpaRepository<Product,Integer> {//entity and primary key type.

}
