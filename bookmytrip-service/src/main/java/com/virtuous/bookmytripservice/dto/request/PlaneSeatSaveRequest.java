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
public class PlaneSeatSaveRequest {
    @NotNull(message = "Plane seat number can't be null")
    @Positive(message = "Plane seat number must be a positive number")
    @DecimalMax(value = "2147483647", message = "Plane seat number can't be more than 2147483647")
    private int number;
    @NotBlank(message = "Plane seat letter required")
    @Size(min = 1, max = 1, message = "Plane seat letter must be 1 character")
    private String letter;
    @NotBlank(message = "Plane seat class required")
    @Size(max = 255, message = "Plane seat class can't be more than 255 characters")
    private String planeSeatClass;
}
