package com.rabbitmq.publisher;

import com.rabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMqJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routingKey.json.name}")
    private String jsonroutingKey;

    private RabbitTemplate rabbitTemplate;

    private static final Logger logger= LoggerFactory.getLogger(RabbitMqJsonProducer.class);

    public RabbitMqJsonProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }

    public void sendJsonMessage(User user){
        logger.info(String.format("JsonDataUser Message sent -> %s",user));
        rabbitTemplate.convertAndSend(exchange,jsonroutingKey,user);
    }


}
