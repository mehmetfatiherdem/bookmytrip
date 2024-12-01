package com.virtuous.bookmytripservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightSearchRequest {
    @NotBlank(message = "Flight ID required")
    @Size(min = 36, max = 36, message = "Flight ID must be 36 characters long UUID")
    private UUID id;
    @NotBlank(message = "Departure required")
    @Size(max = 255, message = "Departure can't be more than 255 characters")
    private String departure;
    @NotBlank(message = "Arrival required")
    @Size(max = 255, message = "Arrival can't be more than 255 characters")
    private String arrival;
    @NotBlank(message = "Departure time required")
    @FutureOrPresent(message = "Departure time can't be in the past")
    private ZonedDateTime departureTime;
    @NotBlank(message = "Departure date required")
    @FutureOrPresent(message = "Departure date can't be in the past")
    private LocalDate departureDate;
    @NotBlank(message = "Arrival time required")
    @FutureOrPresent(message = "Arrival time can't be in the past")
    private ZonedDateTime arrivalTime;
    @NotNull(message = "Flight ticket price can't be null")
    @PositiveOrZero(message = "Flight ticket price can't be a negative number")
    private BigDecimal price;
    @NotBlank(message = "Flight number required")
    @Size(max = 255, message = "Flight number can't be more than 255 characters")
    private String flightNumber;
    @NotBlank(message = "Departure airport ID required")
    @Size(min = 36, max = 36, message = "Departure airport ID must be 36 characters long UUID")
    private UUID departureAirportId;
    @NotBlank(message = "Departure airport code required")
    @Size(min = 3, max = 3, message = "Departure airport code must be 3 characters long")
    private String departureAirportCode;
    @NotBlank(message = "Arrival airport ID required")
    @Size(min = 36, max = 36, message = "Arrival airport ID must be 36 characters long UUID")
    private UUID arrivalAirportId;
    @NotBlank(message = "Arrival airport code required")
    @Size(min = 3, max = 3, message = "Arrival airport code must be 3 characters long")
    private String arrivalAirportCode;
    @NotBlank(message = "Airline ID required")
    @Size(min = 36, max = 36, message = "Airline ID must be 36 characters long UUID")
    private UUID airlineId;
    @NotBlank(message = "Airline code required")
    @Size(min = 3, max = 3, message = "Airline code must be 3 characters long")
    private String airlineCode;
    @NotBlank(message = "Plane ID required")
    @Size(min = 36, max = 36, message = "Plane ID must be 36 characters long UUID")
    private UUID planeId;

    public FlightSearchRequest(String airlineCode, String departureAirportCode, String arrivalAirportCode, LocalDate departureDate) {
        this.departureDate = departureDate;
        this.departureAirportCode = departureAirportCode;
        this.arrivalAirportCode = arrivalAirportCode;
        this.airlineCode = airlineCode;
    }

}
