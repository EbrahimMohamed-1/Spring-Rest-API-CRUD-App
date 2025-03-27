package com.example.springrestapicrudapp.service;

import com.example.springrestapicrudapp.dao.ProductDetailsRepository;
import com.example.springrestapicrudapp.dao.ProductRepository;
import com.example.springrestapicrudapp.exception.ProductNotFoundException;
import com.example.springrestapicrudapp.exception.errorMessage.ErrorMessages.*;

import com.example.springrestapicrudapp.model.Product;
import com.example.springrestapicrudapp.model.ProductDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDetailsRepository productDetailsRepository;

    @Override
    public Product insert(ProductDetails productDetails) {
        Product product = new Product();
        product.setName(productDetails.getName());
        product.setProductDetails(productDetails);
        productRepository.save(product);
        return product;
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException(ProductErrorMessage.PRODUCT_NOT_FOUND));
    }

    @Override
    public ProductDetails findProductDetailsById(int id) {

        return productDetailsRepository.findByProductId(id)
                .orElseThrow(()->new ProductNotFoundException(ProductErrorMessage.PRODUCT_NOT_FOUND));
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDetails update(int id, ProductDetails productDetails) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            Product product1 = product.get();
            product1.setName(productDetails.getName());
            product1.setProductDetails(productDetails);
            productRepository.save(product1);
            return productDetails ;
        }
        else throw new ProductNotFoundException(ProductErrorMessage.PRODUCT_NOT_FOUND);

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
