package com.virtuous.bookmytripuserservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleRequest {
    @NotBlank(message = "You must enter a valid email")
    @Email(message = "You must enter a valid email")
    @Size(min = 11, max = 255, message = "You must enter a valid email") //TODO: check this before pushing to prod
    private String email;
    @NotBlank(message = "Role name required")
    @Size(max = 255, message = "Role name can't be more than 255 characters")
    private String roleName;

}
