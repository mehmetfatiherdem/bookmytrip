package com.virtuous.bookmytripservice.dto.request;

import com.virtuous.bookmytripservice.validation.AtLeastOneNonEmpty;
import com.virtuous.bookmytripservice.validation.IfExistsSize;
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
        fields = {},
        message = ""
)
public class FlightPartialUpdateRequest {
    @Size(max = 255, message = "Flight number can't be more than 255 characters")
    private Optional<String> flightNumber;
    @Size(max = 255, message = "Departure can't be more than 255 characters")
    private Optional<String> departure;
    @Size(max = 255, message = "Arrival can't be more than 255 characters")
    private Optional<String> arrival;
    @Size(max = 255, message = "Flight status can't be more than 255 characters")
    private Optional<String> status;
    @FutureOrPresent(message = "Departure time can't be in the past")
    private Optional<ZonedDateTime> departureTime;
    @FutureOrPresent(message = "Arrival time can't be in the past")
    private Optional<ZonedDateTime> arrivalTime;
    @IfExistsSize(size = 3, message = "Departure airport code must be 3 characters long")
    private Optional<String> departureAirportCode;
    @IfExistsSize(size = 3, message = "Arrival airport code must be 3 characters long")
    private Optional<String> arrivalAirportCode;
    @IfExistsSize(size = 2, message = "Airline code must be 2 characters long")
    private Optional<String> airlineCode;
    @IfExistsSize(size = 36, message = "Plane ID must be 36 characters long UUID")
    private Optional<String> planeId;
}
