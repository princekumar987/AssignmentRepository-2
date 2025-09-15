package com.kafka.consumer;


import com.kafka.entity.WikimediaData;
import com.kafka.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikimediaKafkaConsumer {

         private static final Logger logger= LoggerFactory.getLogger(WikimediaKafkaConsumer.class);

         private WikimediaRepository wikimediaRepository;

         public WikimediaKafkaConsumer(WikimediaRepository wikimediaRepository){
             this.wikimediaRepository=wikimediaRepository;
         }

         @KafkaListener(
                 topics = "wikimedia-change",
                 groupId = "my-group")

         public void consume(String message){

             logger.info("Message Recieved->"+message);

             WikimediaData wikimediaData=new WikimediaData();
             wikimediaData.setMessageData(message);

             wikimediaRepository.save(wikimediaData);
         }
}
