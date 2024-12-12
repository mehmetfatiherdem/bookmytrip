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
        fields = {"brand", "model"},
        message = "At least one of 'brand' or 'model' must be non-empty"
)
public class PlanePartialUpdateRequest {
    @Size(max = 255, message = "Plane brand can't be more than 255 characters")
    private Optional<String> brand;
    @Size(max = 255, message = "Plane model can't be more than 255 characters")
    private Optional<String> model;
}
