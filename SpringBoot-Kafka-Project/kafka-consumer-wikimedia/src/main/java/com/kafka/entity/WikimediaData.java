package com.kafka.entity;


import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class WikimediaData {

    private String id;
    private String messageData;

}
