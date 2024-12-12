package com.virtuous.bookmytripservice.dto.request;

import com.virtuous.bookmytripservice.validation.AtLeastOneNonEmpty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Positive;
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
        fields = {"number"},
        message = "bus seat number must be non-empty"
)
public class BusSeatPartialUpdateRequest {

    private Optional<@Positive(message = "Bus seat number must be a positive number")
    @DecimalMax(value = "2147483647", message = "Bus seat number can't be more than 2147483647")Integer> number;
}
