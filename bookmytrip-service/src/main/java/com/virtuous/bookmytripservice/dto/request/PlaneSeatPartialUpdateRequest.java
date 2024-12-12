package com.virtuous.bookmytripservice.dto.request;

import com.virtuous.bookmytripservice.validation.AtLeastOneNonEmpty;
import com.virtuous.bookmytripservice.validation.IfExistsSize;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Positive;
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
        fields = {"number", "letter", "planeSeatClass"},
        message = "At least one of 'number', 'letter' or 'planeSeatClass' must be non-empty"
)
public class PlaneSeatPartialUpdateRequest {
    //TODO: check if this gives error if so create an annotation eg. IfExistsPositive
    @Positive(message = "Plane seat number must be a positive number")
    @DecimalMax(value = "2147483647", message = "Plane seat number can't be more than 2147483647")
    private Optional<Integer> number;
    @IfExistsSize(size = 1,  message = "Plane seat letter must be 1 character")
    private Optional<String> letter;
    @Size(max = 255, message = "Plane seat class can't be more than 255 characters")
    private Optional<String> planeSeatClass;
}
