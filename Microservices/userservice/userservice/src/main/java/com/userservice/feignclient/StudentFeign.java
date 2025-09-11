package com.userservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "orderservice"  )
public interface StudentFeign {

    @GetMapping("/order/order/{id}")
    public ResponseEntity<List<String>> getOrder(@PathVariable int id);

}
