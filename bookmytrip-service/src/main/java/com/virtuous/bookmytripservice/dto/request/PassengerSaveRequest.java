package com.virtuous.bookmytripservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PassengerSaveRequest {
    @NotBlank(message = "Passenger ID number required")
    @Size(max = 255, message = "Passenger ID number can't be more than 255 characters")
    private String identificationNumber;
    @NotBlank(message = "Passenger name required")
    @Size(max = 255, message = "Passenger name can't be more than 255 characters")
    private String name;
    @NotBlank(message = "Passenger last name required")
    @Size(max = 255, message = "Passenger last name can't be more than 255 characters")
    private String lastName;
    @NotBlank(message = "Passenger phone number required")
    @Size(max = 255, message = "Passenger phone number can't be more than 255 characters")
    private String phoneNumber;
    private String gender;
    @NotNull(message = "Passenger age can't be null")
    @PositiveOrZero(message = "Passenger age can't be a negative number")
    @DecimalMax(value = "2147483647", message = "Passenger age can't be more than 2147483647")
    private Integer age;
}
