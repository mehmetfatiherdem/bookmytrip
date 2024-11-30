package com.virtuous.bookmytripservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusTicketSaveRequest {
    private String tripId;
    private String ticketStatus;
    private BigDecimal price;
    private String busSeatId;
}
