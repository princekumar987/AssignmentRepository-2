package com.product.service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product addService(Product product){
         return productRepository.save(product);
    }

    public List<Product> allService(){
        return productRepository.findAll();
    }

    public List<Product> getALlServiceByType(String type){
        return productRepository.findByType(type);
    }
}
