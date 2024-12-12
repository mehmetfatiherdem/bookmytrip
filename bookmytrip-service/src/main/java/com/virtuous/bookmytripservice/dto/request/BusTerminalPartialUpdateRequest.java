package com.virtuous.bookmytripservice.dto.request;

import com.virtuous.bookmytripservice.validation.AtLeastOneNonEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@AtLeastOneNonEmpty(
        fields = {"name", "city", "country", "timeZone"},
        message = "At least one of 'name', 'city', 'country', 'timeZone'"
)
public class BusTerminalPartialUpdateRequest {

    private Optional<@Size(max = 255, message = "Bus terminal name can't be more than 255 characters")String> name;

    private Optional<@Size(max = 255, message = "Bus terminal city can't be more than 255 characters")String> city;

    private Optional<@Size(max = 255, message = "Bus terminal country can't be more than 255 characters")String> country;

    private Optional<@Size(max = 255, message = "Bus terminal time zone can't be more than 255 characters")String> timeZone;
}
