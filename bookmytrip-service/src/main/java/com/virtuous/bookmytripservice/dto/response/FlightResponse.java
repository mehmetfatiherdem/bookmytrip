package com.virtuous.bookmytripservice.dto.response;

import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightResponse implements Serializable {
    private String flightNumber;
    private String departure;
    private String arrival;
    private String status;
    private ZonedDateTime departureTime;
    private ZonedDateTime arrivalTime;
    private AirportResponse departureAirport;
    private AirportResponse arrivalAirport;
    private AirlineResponse airline;
    private PlaneResponse plane;
}
