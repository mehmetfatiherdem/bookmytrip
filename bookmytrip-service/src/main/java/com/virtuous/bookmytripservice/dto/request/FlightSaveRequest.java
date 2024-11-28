package com.virtuous.bookmytripservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightSaveRequest {
    private String flightNumber;
    private String departure;
    private String arrival;
    private String status;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String departureAirportCode;
    private String arrivalAirportCode;
    private String airlineCode;
    private UUID planeId;

}
