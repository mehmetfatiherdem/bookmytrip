package com.virtuous.bookmytripservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusTripSaveRequest {
    @NotBlank(message = "Trip number required")
    @Size(max = 255, message = "Trip number can't be more than 255 characters")
    private String tripNumber;
    @NotBlank(message = "Departure required")
    @Size(max = 255, message = "Departure can't be more than 255 characters")
    private String departure;
    @NotBlank(message = "Arrival required")
    @Size(max = 255, message = "Arrival can't be more than 255 characters")
    private String arrival;
    @NotBlank(message = "Bus trip status can't be blank")
    @Size(max = 255, message = "Bus trip status can't be more than 255 characters")
    private String status;
    @NotBlank(message = "Departure time required")
    @FutureOrPresent(message = "Departure time can't be in the past")
    private ZonedDateTime departureTime;
    @NotBlank(message = "Arrival time required")
    @FutureOrPresent(message = "Arrival time can't be in the past")
    private ZonedDateTime arrivalTime;
    @NotBlank(message = "Departure bus terminal ID required")
    @Size(min = 36, max = 36, message = "Departure bus terminal ID must be 36 characters long UUID")
    private UUID departureBusTerminalId;
    @NotBlank(message = "Arrival bus terminal ID required")
    @Size(min = 36, max = 36, message = "Arrival bus terminal ID must be 36 characters long UUID")
    private UUID arrivalBusTerminalId;
    @NotBlank(message = "Bus operator ID required")
    @Size(min = 36, max = 36, message = "Bus operator ID must be 36 characters long UUID")
    private UUID busOperatorId;
    @NotBlank(message = "Bus ID required")
    @Size(min = 36, max = 36, message = "Bus ID must be 36 characters long UUID")
    private String busId;
}
