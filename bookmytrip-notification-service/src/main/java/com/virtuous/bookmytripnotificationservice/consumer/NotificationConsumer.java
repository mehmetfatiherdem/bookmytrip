package com.virtuous.bookmytripnotificationservice.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtuous.bookmytripnotificationservice.dto.EmailMessage;
import com.virtuous.bookmytripnotificationservice.dto.NotificationMessage;
import com.virtuous.bookmytripnotificationservice.service.NotificationContext;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    private final NotificationContext notificationContext;
    private final ObjectMapper mapper;

    public NotificationConsumer(NotificationContext notificationContext, ObjectMapper mapper) {
        this.notificationContext = notificationContext;
        this.mapper = mapper;
    }



    // @RabbitListener(queues = {"emailQueue", "smsQueue", "pushNotificationQueue"})
    @RabbitListener(queues = {"emailQueue"})
    public void receiveNotification(String message, @Header("amqp_receivedRoutingKey") String routingKey) {

        try {
            NotificationMessage notificationMessage = mapper.readValue(message, NotificationMessage.class);
            notificationContext.executeStrategy(routingKey, notificationMessage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
