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
public class BusTicketSaveRequest {
    @NotBlank(message = "Trip ID required")
    @Size(min = 36, max = 36, message = "Trip ID must be 36 characters long UUID")
    private String tripId;
    @NotBlank(message = "Ticket status required")
    @Size(max = 255, message = "Ticket status can't be more than 255 characters")
    private String ticketStatus;
    @NotNull(message = "Bus ticket price can't be null")
    @PositiveOrZero(message = "Bus ticket price can't be a negative number")
    private BigDecimal price;
    @NotBlank(message = "Bus ID required")
    @Size(min = 36, max = 36, message = "Bus ID must be 36 characters long UUID")
    private String busSeatId;
}
