package com.virtuous.bookmytripuserservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue emailQueue() {
        return new Queue("emailQueue", false);
    }

    @Bean
    public Exchange exchange() {
        return new DirectExchange("notificationExchange");
    }

    @Bean
    public Binding emailBinding(Queue emailQueue, Exchange exchange) {
        return BindingBuilder.bind(emailQueue)
                .to(exchange)
                .with("notification.email")
                .noargs();
    }
}
