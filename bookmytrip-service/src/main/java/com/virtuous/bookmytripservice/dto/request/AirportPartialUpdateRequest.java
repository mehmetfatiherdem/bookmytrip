package com.virtuous.bookmytripservice.dto.request;

import com.virtuous.bookmytripservice.validation.AtLeastOneNonEmpty;
import com.virtuous.bookmytripservice.validation.IfExistsSize;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AtLeastOneNonEmpty(
        fields = {"code", "name", "city", "country", "timeZone"},
        message = "At least one of 'code', 'name', 'city', 'country', 'timeZone' must be non-empty"
)
public class AirportPartialUpdateRequest {
    @IfExistsSize(size = 3, message = "Airport code must be 3 characters long")
    private Optional<String> code;
    @Size(max = 255, message = "Airport name can't be more than 255 characters")
    private Optional<String>  name;
    @Size(max = 255, message = "Airport city can't be more than 255 characters")
    private Optional<String>  city;
    @Size(max = 255, message = "Airport country can't be more than 255 characters")
    private Optional<String>  country;
    @Size(max = 255, message = "Airport timeZone can't be more than 255 characters")
    private Optional<String>  timeZone;
}
