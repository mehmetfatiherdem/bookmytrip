package com.virtuous.bookmytripservice.dto.request;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
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
) // TODO: at leastonenonempty does not work
public class PlanePartialUpdateRequest {
    private Optional<@Size(max = 255, message = "Plane brand can't be more than 255 characters")String> brand = Optional.empty();
    private Optional<@Size(max = 255, message = "Plane model can't be more than 255 characters")String> model = Optional.empty();
    // TODO: empty worked but not sure if it is an optimal way to solve this
}
