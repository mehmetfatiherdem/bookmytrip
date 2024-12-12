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

public class BusSaveRequest {
    @NotBlank(message = "Bus brand required")
    @Size(max = 255, message = "Bus brand can't be more than 255 characters")
    private String brand;
    @NotBlank(message = "Bus model required")
    @Size(max = 255, message = "Bus model can't be more than 255 characters")
    private String model;

}
