package com.virtuous.bookmytripservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AirportSaveRequest {
    @NotBlank(message = "Airport code required")
    @Size(min = 3, max = 3, message = "Airport code must be 3 characters long")
    private String code;
    @NotBlank(message = "Airport name required")
    @Size(max = 255, message = "Airport name can't be more than 255 characters")
    private String name;
    @NotBlank(message = "Airport city required")
    @Size(max = 255, message = "Airport city can't be more than 255 characters")
    private String city;
    @NotBlank(message = "Airport country required")
    @Size(max = 255, message = "Airport country can't be more than 255 characters")
    private String country;
    @NotBlank(message = "Airport timeZone required")
    @Size(max = 255, message = "Airport timeZone can't be more than 255 characters")
    private String timeZone;

}
