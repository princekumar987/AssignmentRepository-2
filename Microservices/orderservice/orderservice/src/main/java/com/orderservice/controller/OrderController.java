package com.orderservice.controller;

import com.orderservice.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

   // private static final Logger log= LoggerFactory.getLogger(OrderController.class);

    @GetMapping("test")
    public String test(){

        log.info("info point ");
        log.debug("debug point");
        log.trace("trace point");
        log.error("error point");
        return "order-service";

    }

    @PostMapping("create")
    public ResponseEntity<Order> getOrder(@RequestBody Order order){

        System.out.println(order);
        log.info("Hello jiiii");
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(order);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<List<String>> getOrder(@PathVariable int id){
        System.out.println("Order-service:--user_id :-"+id);
        List<String>list= List.of("Rice","sbg","Dal","Pizza");

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(list);
    }
}
