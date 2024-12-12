package com.virtuous.bookmytripservice.dto.request;

import com.virtuous.bookmytripservice.validation.AtLeastOneNonEmpty;
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
        fields = {"name"},
        message = "'name' must be non-empty"
)
public class BusOperatorPartialUpdateRequest {
    @Size(max = 255, message = "Bus operator name can't be more than 255 characters")
    private Optional<String> name;
}
