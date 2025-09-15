package com.kafka.repository;

import com.kafka.entity.WikimediaData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WikimediaRepository extends MongoRepository<WikimediaData,String> {
}
