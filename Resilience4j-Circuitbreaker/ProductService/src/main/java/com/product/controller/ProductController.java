package com.product.controller;

import com.product.entity.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
           return ResponseEntity.status(201).body(productService.addService(product));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
          return ResponseEntity.status(200).body(productService.allService());
    }

    @GetMapping("/product/{type}")
    public ResponseEntity<List<Product>> getProductById(@PathVariable String  type){
         return ResponseEntity.status(200).body(productService.getALlServiceByType(type));
    }
}
