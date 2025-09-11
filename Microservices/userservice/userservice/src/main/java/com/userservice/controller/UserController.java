package com.userservice.controller;

import com.userservice.dto.User;
import com.userservice.feignclient.StudentFeign;
import com.userservice.service.OrderWebClient;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {



    private UserService userService;
    private StudentFeign studentFeign;
    private OrderWebClient orderWebClient;

    public UserController(UserService userService, StudentFeign studentFeign, OrderWebClient orderWebClient) {
        this.userService = userService;
        this.studentFeign = studentFeign;
        this.orderWebClient = orderWebClient;
    }

    @GetMapping("test")
    public String test(){
        return "User-Service";
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user){

        System.out.println(user);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(user);
    }

    // ResTemplate used

    @GetMapping("order/{id}")
    public ResponseEntity<List<String>> getOrder(@PathVariable int id){
        System.out.println("user-id: "+id);
        return userService.getOrder(id);
    }

    //feign client used

    @GetMapping("orderfeign/{id}")
    public ResponseEntity<List<String>> getOrder1(@PathVariable int id){
        System.out.println("user-id: "+id);
        return studentFeign.getOrder(id);
    }


    //webclient

    @GetMapping("/orderweb/{id}")
    public List<String> getOrderByUser(@PathVariable int id) {
        return orderWebClient.getOrder(id);
    }

}
