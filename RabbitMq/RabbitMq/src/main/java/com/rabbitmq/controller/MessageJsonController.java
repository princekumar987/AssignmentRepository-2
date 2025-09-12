package com.rabbitmq.controller;


import com.rabbitmq.dto.User;
import com.rabbitmq.publisher.RabbitMqJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class MessageJsonController {

    private RabbitMqJsonProducer rabbitMqJsonProducer;

    public MessageJsonController(RabbitMqJsonProducer rabbitMqJsonProducer){
        this.rabbitMqJsonProducer=rabbitMqJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user){
         rabbitMqJsonProducer.sendJsonMessage(user);
         return ResponseEntity.ok("JsonMessage Data Sent:....");
    }
}
