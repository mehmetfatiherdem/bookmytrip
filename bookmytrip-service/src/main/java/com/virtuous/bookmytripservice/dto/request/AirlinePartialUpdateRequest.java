package com.virtuous.bookmytripservice.dto.request;

import com.virtuous.bookmytripservice.validation.AtLeastOneNonEmpty;
import com.virtuous.bookmytripservice.validation.IfExistsSize;
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
        fields = {"code", "name"},
        message = "At least one of 'code' or 'name' must be non-empty"
)
public class AirlinePartialUpdateRequest {
    private Optional<@IfExistsSize(size = 2, message = "Airline code must be 2 characters long")String> code;

    private Optional< @Size(max = 255, message = "Airline name can't be more than 255 characters")String> name;
}
