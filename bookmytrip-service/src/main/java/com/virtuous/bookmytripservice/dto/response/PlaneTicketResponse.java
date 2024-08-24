package com.virtuous.bookmytripservice.dto.response;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaneTicketResponse implements Serializable {
    private String flightNumber;
    private String departure;
    private String arrival;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private BigDecimal price;
    private AirportResponse departureAirport;
    private AirportResponse arrivalAirport;
    private AirlineResponse airline;
    private PlaneResponse plane;
}
