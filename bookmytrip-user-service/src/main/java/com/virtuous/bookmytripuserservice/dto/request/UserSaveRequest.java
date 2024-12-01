package com.virtuous.bookmytripuserservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSaveRequest {
    @NotBlank(message = "Name required")
    @Size(max = 255, message = "Name can't be more than 255 characters")
    private String name;
    @NotBlank(message = "Last name required")
    @Size(max = 255, message = "Last name can't be more than 255 characters")
    private String lastName;
    @NotBlank(message = "You must enter a valid email")
    @Email(message = "You must enter a valid email")
    @Size(min = 11, max = 255, message = "You must enter a valid email") //TODO: check this before pushing to prod
    private String email;
    @NotBlank(message = "Phone number required")
    @Size(max = 255, message = "Phone number can't be more than 255 characters")
    private String phoneNumber;
    @NotBlank(message = "Enter a valid password")
    @Size(min = 6, max = 255, message = "Password should be between 6-255 characters") //TODO: check this before pushing to prod
    private String password;

}