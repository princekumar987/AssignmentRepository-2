package com.kafka.kafka;

import com.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "My-Java-topic-json", groupId = "my-group")
    public void consume(User user){
          logger.info(String.format("Json Message Received-> %s",user));
    }
}
