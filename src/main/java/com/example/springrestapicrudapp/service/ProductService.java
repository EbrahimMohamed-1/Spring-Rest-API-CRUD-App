package com.example.springrestapicrudapp.service;

import com.example.springrestapicrudapp.model.Product;
import com.example.springrestapicrudapp.model.ProductDetails;

import java.util.List;


public interface ProductService {
    Product insert(ProductDetails product) ;
    Product findById(int id);

    ProductDetails findProductDetailsById(int id);
    void deleteById(int id);
    ProductDetails update(int id, ProductDetails productDetails);
    List<Product> findAll();
}
