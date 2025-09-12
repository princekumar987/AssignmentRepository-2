package com.rabbitmq.consumer;


import com.rabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqJsonConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqJsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consume(User user){
        logger.info(String.format("Recieved Message -> %s",user));
    }
}
