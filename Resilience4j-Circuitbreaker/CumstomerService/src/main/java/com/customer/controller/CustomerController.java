package com.customer.controller;

import com.customer.entity.Product;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("products")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.status(200).body(customerService.getAllProducts());
    }

    @GetMapping("/product/{type}")
    public ResponseEntity<List<Product>> getAllProductsByTpe(@PathVariable String type){
        return ResponseEntity.status(200).body(customerService.getProductByType(type));
    }
}
