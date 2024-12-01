package com.virtuous.bookmytripservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusTicketBookingRequest {
    @NotBlank(message = "Bus ticket ID required")
    @Size(min = 36, max = 36, message = "Bus ticket ID must be 36 characters long UUID")
    private String busTicketId;
    @NotBlank(message = "Passenger ID number required")
    @Size(max = 255, message = "Passenger ID number can't be more than 255 characters")
    private String passengerIdentificationNumber;
    @NotBlank(message = "Passenger name required")
    @Size(max = 255, message = "Passenger name can't be more than 255 characters")
    private String passengerName;
    @NotBlank(message = "Passenger last name required")
    @Size(max = 255, message = "Passenger last name can't be more than 255 characters")
    private String passengerLastName;
    @NotBlank(message = "Passenger phone number required")
    @Size(max = 255, message = "Passenger phone number can't be more than 255 characters")
    private String passengerPhoneNumber;
    @NotBlank(message = "Gender required")
    @Size(max = 255, message = "Gender can't be more than 255 characters")
    private String passengerGender;
    @NotNull(message = "Passenger age can't be null")
    @PositiveOrZero(message = "Passenger age can't be a negative number")
    @DecimalMax(value = "2147483647", message = "Passenger age can't be more than 2147483647")
    private Integer passengerAge;
}
