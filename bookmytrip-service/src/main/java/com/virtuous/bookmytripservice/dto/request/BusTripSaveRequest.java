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
public class BusTripSaveRequest {

    private String tripNumber;
    private String departure;
    private String arrival;
    private String status;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private BigDecimal price;
    private UUID departureBusTerminalId;
    private UUID arrivalBusTerminalId;
    private UUID busOperatorId;
    private UUID busId;
}
