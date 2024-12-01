package com.virtuous.bookmytripservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AirlineSaveRequest {
    @NotBlank(message = "Airline code required")
    @Size(min = 2, max = 2, message = "Airline code must be 2 characters long")
    private String code;
    @NotBlank(message = "Airline name required")
    @Size(max = 255, message = "Airline name can't be more than 255 characters")
    private String name;

}
