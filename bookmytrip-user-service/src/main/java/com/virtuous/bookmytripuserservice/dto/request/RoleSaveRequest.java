package com.virtuous.bookmytripuserservice.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleSaveRequest {
    @NotBlank(message = "Role name required")
    @Size(max = 255, message = "Role name can't be more than 255 characters")
    private String name;
}
