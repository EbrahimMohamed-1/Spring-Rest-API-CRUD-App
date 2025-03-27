package com.example.springrestapicrudapp.controller;

import com.example.springrestapicrudapp.exception.response.ProductErrorResponse;
import com.example.springrestapicrudapp.model.Product;
import com.example.springrestapicrudapp.model.ProductDetails;
import com.example.springrestapicrudapp.service.ProductService;


import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping("api/v1/product")
    @ApiResponse(responseCode = "200", description = "Successful response" )

    @ApiResponse(responseCode = "404", description = "Product not found", useReturnTypeSchema = true)
    @Schema(implementation = ProductErrorResponse.class)
    public Product getProduct(@RequestParam("id") int id){
        Product product = productService.findById(id);
        return product;
    }

    @PostMapping("api/v1/product")
    public Product createProduct(@RequestBody ProductDetails productDetails){
        return productService.insert(productDetails);
    }

    @GetMapping("api/v1/productDetails")
    @ApiResponse(responseCode = "404", description = "Product not found")
    public ProductDetails getProductDetails(@RequestParam("id") int id){
        return productService.findProductDetailsById(id);
    }

    @DeleteMapping("api/v1/product")
    public void deleteProduct(@RequestParam("id") int id){
        productService.deleteById(id);
    }

    @PutMapping("api/v1/product")
    @ApiResponse(responseCode = "404", description = "Product not found")
    public ProductDetails update(@RequestParam("id") int id, @RequestBody ProductDetails productDetails){
        return productService.update(id, productDetails);
    }

    @GetMapping("api/v2/products")
    public List<Product> FindAll(){
        return productService.findAll();
    }

}
