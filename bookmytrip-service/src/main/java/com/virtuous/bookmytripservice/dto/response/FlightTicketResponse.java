package com.virtuous.bookmytripservice.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightTicketResponse {
    private TripResponse trip;
    private String ticketStatus;
    private BigDecimal price;
    private PassengerResponse passenger;
    private String userEmail;
    private PlaneSeatResponse planeSeat;
    private String boardingGate;
}
