package com.virtuous.bookmytripuserservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {
    @NotBlank(message = "You must enter a valid email")
    @Email(message = "You must enter a valid email")
    @Size(min = 11, max = 255, message = "You must enter a valid email") //TODO: check this before pushing to prod
    private String email;
    @NotBlank(message = "Enter a valid password")
    @Size(min = 6, max = 255, message = "Password should be between 6-255 characters") //TODO: check this before pushing to prod
    private String password;
}
