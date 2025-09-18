package com.customer.service;

import com.customer.entity.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    private RestTemplate restTemplate;


    @CircuitBreaker(name = "productService", fallbackMethod = "getProductsFallback")
    public List<Product> getAllProducts(){
        String url="http://localhost:8080/api/v1/products";
        return List.of(restTemplate.getForObject(url, Product[].class));
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "getProductsFallback")
    public List<Product> getProductByType(String  type){
        String url="http://localhost:8080/api/v1/product/"+type;
        return List.of(restTemplate.getForObject(url, Product[].class));
    }

    public List<Product> getProductsFallback(Throwable t) {
        logger.info(t.getMessage());
        return Arrays.asList(
                new Product(0, "Default Product", "N/A", 0)
        );
    }

}
