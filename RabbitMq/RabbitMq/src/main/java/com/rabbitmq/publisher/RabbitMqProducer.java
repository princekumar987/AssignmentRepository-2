package com.rabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMqProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routingKey.name}")
    private String routingKey;

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqProducer.class);


    private RabbitTemplate rabbitTemplate;

    public RabbitMqProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }

    public void sendMessage(String message){
        logger.info(String.format("Message sent -> %s", message));

        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }
}
