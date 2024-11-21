package com.virtuous.bookmytripexceptionservice.service;

import com.virtuous.bookmytripexceptionservice.model.ExceptionDocument;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class KafkaConsumerService {

    private final MongoTemplate mongoTemplate;


    @KafkaListener(topics = "exceptions", groupId = "exception_group")
    public void consume(String exceptionMessage) {
        mongoTemplate.save(new ExceptionDocument(exceptionMessage), "exceptions");
    }
}
