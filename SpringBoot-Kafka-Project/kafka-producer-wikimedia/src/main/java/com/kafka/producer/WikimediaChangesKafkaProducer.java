package com.kafka.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import okhttp3.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesKafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(WikimediaChangesKafkaProducer.class);

    private KafkaTemplate<String,String> kafkaTemplate;

    public WikimediaChangesKafkaProducer(KafkaTemplate<String,String>kafkaTemplate){
         this.kafkaTemplate=kafkaTemplate;
    }

    public void produce() throws InterruptedException {

        String topic="wikimedia-change";

        //to read real time data from wikimedia , we use eventsource::;

        EventHandler eventHandler=new WikimediaChangesHandler(kafkaTemplate, topic);

        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        Headers headers = new Headers.Builder()
                .add("User-Agent", "MyKafkaProducer/1.0 (https://example.com/)")
                .build();

        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url))
                .headers(headers);

        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);

    }

}
