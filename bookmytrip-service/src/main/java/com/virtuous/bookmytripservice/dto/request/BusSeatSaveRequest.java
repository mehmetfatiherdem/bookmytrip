package com.virtuous.bookmytripservice.dto.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusSeatSaveRequest {
    @NotNull(message = "Bus seat number can't be null")
    @Positive(message = "Bus seat number must be a positive number")
    @DecimalMax(value = "2147483647", message = "Bus seat number can't be more than 2147483647")
    private int number;
}
