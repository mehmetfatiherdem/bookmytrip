package com.virtuous.bookmytripservice.dto.request;

import com.virtuous.bookmytripservice.validation.AtLeastOneNonEmpty;
import com.virtuous.bookmytripservice.validation.IfExistsSize;
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
        fields = {"tripId", "ticketStatus", "price", "planeSeatId"},
        message = "At least one of 'tripId', 'ticketStatus', 'price' or 'planeSeatId' must be non-empty"
)
public class FlightTicketPartialUpdateRequest {
    @IfExistsSize(size = 36, message = "Trip ID must be 36 characters long UUID")
    private Optional<String> tripId;
    @Size(max = 255, message = "Ticket status can't be more than 255 characters")
    private Optional<String> ticketStatus;
    //TODO: check if this gives error if so create an annotation eg. IfExistsPositiveOrZero
    @PositiveOrZero(message = "Flight ticket price can't be a negative number")
    private Optional<BigDecimal> price;
    @IfExistsSize(size = 36, message = "Plane seat ID must be 36 characters long UUID")
    private Optional<String> planeSeatId;
}
