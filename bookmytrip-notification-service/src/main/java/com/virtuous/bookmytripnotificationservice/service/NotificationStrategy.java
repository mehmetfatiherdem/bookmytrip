package com.virtuous.bookmytripnotificationservice.service;

import com.virtuous.bookmytripnotificationservice.dto.NotificationMessage;

public interface NotificationStrategy {
    void send(NotificationMessage message);
}
