package com.virtuous.bookmytripservice.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponse {
    private String ticketId;
    private TripResponse trip;
    private String ticketStatus;
    private BigDecimal ticketPrice;
    private PassengerResponse passenger;
}
