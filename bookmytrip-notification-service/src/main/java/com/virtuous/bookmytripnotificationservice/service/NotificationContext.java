package com.virtuous.bookmytripnotificationservice.service;

import com.virtuous.bookmytripnotificationservice.dto.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NotificationContext {
    private final Map<String, NotificationStrategy> strategyMap;

    @Autowired
    public NotificationContext(List<NotificationStrategy> notificationStrategies) {
        strategyMap = new HashMap<>();
        for (NotificationStrategy strategy: notificationStrategies) {
            String strategyName = strategy.getClass().getSimpleName().
                    replace("NotificationStrategy", "")
                    .toLowerCase();
            strategyName = "notification." + strategyName;
            strategyMap.put(strategyName, strategy);
        }
    }

    public void executeStrategy(String notificationType, NotificationMessage message) {
        NotificationStrategy strategy = strategyMap.get(notificationType.toLowerCase());
        if (strategy == null) {
            throw new IllegalArgumentException("No strategy found for notification type: " + notificationType);
        }
        strategy.send(message);
    }

}
