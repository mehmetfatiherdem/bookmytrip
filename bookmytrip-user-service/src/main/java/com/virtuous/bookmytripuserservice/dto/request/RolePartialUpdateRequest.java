package com.virtuous.bookmytripuserservice.dto.request;

import com.virtuous.bookmytripuserservice.validation.AtLeastOneNonEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AtLeastOneNonEmpty(
        fields = {"name"},
        message = "'name' must be non-empty"
)
public class RolePartialUpdateRequest {
    @Size(max = 255, message = "Role name can't be more than 255 characters")
    private Optional<String> name;
}
