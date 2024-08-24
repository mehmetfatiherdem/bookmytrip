package com.virtuous.bookmytripservice.dto.request;

import com.virtuous.bookmytripservice.model.Bus;
import com.virtuous.bookmytripservice.model.BusOperator;
import com.virtuous.bookmytripservice.model.BusTerminal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusTicketSaveRequest {

    private String tripNumber;
    private String departure;
    private String arrival;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private BigDecimal price;
    private Long departureBusTerminalId;
    private Long arrivalBusTerminalId;
    private Long busOperatorId;
    private Long busId;
}
