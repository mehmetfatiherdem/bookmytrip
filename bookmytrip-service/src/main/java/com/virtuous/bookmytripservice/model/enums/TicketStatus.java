package com.virtuous.bookmytripservice.model.enums;

public enum TicketStatus {

    AVAILABLE, // The ticket is available for booking
    RESERVED, // The ticket has been temporarily reserved but not yet paid for (e.g., during checkout)
    ON_HOLD, // The ticket is held due to pending payment or verification
    BOOKED, // The ticket has been successfully booked and paid for
    CANCELLED,
    SUSPENDED,
    DELAYED
}
