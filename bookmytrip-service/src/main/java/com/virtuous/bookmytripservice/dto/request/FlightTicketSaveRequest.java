package com.virtuous.bookmytripservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightTicketSaveRequest {
    @NotBlank(message = "Trip ID required")
    @Size(min = 36, max = 36, message = "Trip ID must be 36 characters long UUID")
    private String tripId;
    @NotBlank(message = "Ticket status required")
    private String ticketStatus;
    @NotNull(message = "Flight ticket price can't be null")
    @PositiveOrZero(message = "Flight ticket price can't be a negative number")
    private BigDecimal price;
    @NotBlank(message = "Plane seat ID required")
    @Size(min = 36, max = 36, message = "Plane seat ID must be 36 characters long UUID")
    private String planeSeatId;
}
