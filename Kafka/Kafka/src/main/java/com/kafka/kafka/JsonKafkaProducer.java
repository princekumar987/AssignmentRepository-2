package com.kafka.kafka;

import com.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger logger= LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String,User> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    public void sendMessage(User data){

        logger.info(String.format("Json Message producer-> %s",data));
        Message<User> message= MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"My-Java-topic-json")
                .build();
        kafkaTemplate.send(message);
    }
}
