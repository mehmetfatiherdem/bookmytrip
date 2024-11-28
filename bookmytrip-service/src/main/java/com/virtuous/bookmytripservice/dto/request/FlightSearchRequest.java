package com.virtuous.bookmytripservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightSearchRequest {
    private UUID id;
    private String departure;
    private String arrival;
    private LocalDateTime departureTime;
    private LocalDate departureDate;
    private LocalDateTime arrivalTime;
    private BigDecimal price;
    private String flightNumber;
    private UUID departureAirportId;
    private String departureAirportCode;
    private UUID arrivalAirportId;
    private String arrivalAirportCode;
    private UUID airlineId;
    private String airlineCode;
    private UUID planeId;

    public FlightSearchRequest(String airlineCode, String departureAirportCode, String arrivalAirportCode, LocalDate departureDate) {
        this.departureDate = departureDate;
        this.departureAirportCode = departureAirportCode;
        this.arrivalAirportCode = arrivalAirportCode;
        this.airlineCode = airlineCode;
    }

}
