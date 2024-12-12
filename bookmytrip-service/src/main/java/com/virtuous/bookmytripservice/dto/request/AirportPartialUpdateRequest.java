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

    private Optional<@IfExistsSize(size = 3, message = "Airport code must be 3 characters long")String> code;
    private Optional<@Size(max = 255, message = "Airport name can't be more than 255 characters")String>  name;
    private Optional<@Size(max = 255, message = "Airport city can't be more than 255 characters")String>  city;
    private Optional<@Size(max = 255, message = "Airport country can't be more than 255 characters")String>  country;
    private Optional<@Size(max = 255, message = "Airport timeZone can't be more than 255 characters")String>  timeZone;

    //TODO: put the validator annotations inside the '<>' in all partial update requests for all optional types
}
