package com.virtuous.bookmytripservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightSaveRequest {
    @NotBlank(message = "Flight number required")
    @Size(max = 255, message = "Flight number can't be more than 255 characters")
    private String flightNumber;
    @NotBlank(message = "Departure required")
    @Size(max = 255, message = "Departure can't be more than 255 characters")
    private String departure;
    @NotBlank(message = "Arrival required")
    @Size(max = 255, message = "Arrival can't be more than 255 characters")
    private String arrival;
    @NotBlank(message = "Flight status required")
    @Size(max = 255, message = "Flight status can't be more than 255 characters")
    private String status;
    @NotBlank(message = "Departure time required")
    @FutureOrPresent(message = "Departure time can't be in the past")
    private ZonedDateTime departureTime;
    @NotBlank(message = "Arrival time required")
    @FutureOrPresent(message = "Arrival time can't be in the past")
    private ZonedDateTime arrivalTime;
    @NotBlank(message = "Departure airport code required")
    @Size(min = 3, max = 3, message = "Departure airport code must be 3 characters long")
    private String departureAirportCode;
    @NotBlank(message = "Arrival airport code required")
    @Size(min = 3, max = 3, message = "Arrival airport code must be 3 characters long")
    private String arrivalAirportCode;
    @NotBlank(message = "Airline code required")
    @Size(min = 2, max = 2, message = "Airline code must be 2 characters long")
    private String airlineCode;
    @NotBlank(message = "Plane ID required")
    @Size(min = 36, max = 36, message = "Plane ID must be 36 characters long UUID")
    private UUID planeId;

}
