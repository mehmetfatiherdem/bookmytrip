package com.virtuous.bookmytripuserservice.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtuous.bookmytripuserservice.dto.notification.NotificationMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationProducer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper mapper;

    public NotificationProducer(RabbitTemplate rabbitTemplate, ObjectMapper mapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.mapper = mapper;
    }

    public void sendMessage(String exchange, String routingKey, NotificationMessage message) {
        try {
            String jsonMessage = mapper.writeValueAsString(message);
            rabbitTemplate.convertAndSend(exchange, routingKey, jsonMessage);
        } catch (Exception e) {
            throw new RuntimeException("Error while sending message", e);
        }
    }

}
