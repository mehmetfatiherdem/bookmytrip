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
public class BusTerminalSaveRequest {
    @NotBlank(message = "Bus terminal name required")
    @Size(max = 255, message = "Bus terminal name can't be more than 255 characters")
    private String name;
    @NotBlank(message = "Bus terminal city required")
    @Size(max = 255, message = "Bus terminal city can't be more than 255 characters")
    private String city;
    @NotBlank(message = "Bus terminal country required")
    @Size(max = 255, message = "Bus terminal country can't be more than 255 characters")
    private String country;
    @NotBlank(message = "Bus terminal time zone required")
    @Size(max = 255, message = "Bus terminal time zone can't be more than 255 characters")
    private String timeZone;
}
