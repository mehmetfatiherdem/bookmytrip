package com.virtuous.bookmytripservice.dto.request;

import com.virtuous.bookmytripservice.validation.AtLeastOneNonEmpty;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@AtLeastOneNonEmpty(
        fields = {"tripNumber", "departure", "arrival", "status", "departureTime", "arrivalTime"},
        message = "At least one of 'tripNumber', 'departure', 'arrival', 'status', 'departureTime', 'arrivalTime'"
)
public class BusTripPartialUpdateRequest {
    @Size(max = 255, message = "Trip number can't be more than 255 characters")
    private Optional<String> tripNumber;
    @Size(max = 255, message = "Departure can't be more than 255 characters")
    private Optional<String> departure;
    @Size(max = 255, message = "Arrival can't be more than 255 characters")
    private Optional<String> arrival;
    @Size(max = 255, message = "Bus trip status can't be more than 255 characters")
    private Optional<String> status;
    @FutureOrPresent(message = "Departure time can't be in the past")
    private Optional<ZonedDateTime> departureTime;
    @FutureOrPresent(message = "Arrival time can't be in the past")
    private Optional<ZonedDateTime> arrivalTime;

}
