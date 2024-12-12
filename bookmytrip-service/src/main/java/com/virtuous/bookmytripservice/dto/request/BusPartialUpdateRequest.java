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
        fields = {"brand", "model"},
        message = "At least one of 'brand' or 'model' must be non-empty"
)
public class BusPartialUpdateRequest {
    @Size(max = 255, message = "Bus brand can't be more than 255 characters")
    private Optional<String> brand;
    @Size(max = 255, message = "Bus model can't be more than 255 characters")
    private Optional<String> model;
}
