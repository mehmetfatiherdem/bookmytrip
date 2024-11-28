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
public class BusTripResponse implements Serializable {

    private String tripNumber;
    private String departure;
    private String arrival;
    private String status;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private BigDecimal price;
    private BusTerminalResponse departureBusTerminal;
    private BusTerminalResponse arrivalBusTerminal;
    private BusOperatorResponse busOperator;
    private BusResponse bus;
}
