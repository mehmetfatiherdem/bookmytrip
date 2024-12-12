package com.virtuous.bookmytripservice.dto.request;

import com.virtuous.bookmytripservice.validation.AtLeastOneNonEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@AtLeastOneNonEmpty(
        fields = {"ticketStatus", "price"},
        message = "At least one of 'ticketStatus' or 'price' must be non-empty"
)
public class BusTicketPartialUpdateRequest {
    @Size(max = 255, message = "Ticket status can't be more than 255 characters")
    private Optional<String> ticketStatus;
    @PositiveOrZero(message = "Bus ticket price can't be a negative number")
    private Optional<BigDecimal> price;
}
